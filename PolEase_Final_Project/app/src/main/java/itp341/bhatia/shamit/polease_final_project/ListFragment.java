package itp341.bhatia.shamit.polease_final_project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import itp341.bhatia.shamit.polease_final_project.model.Case;
import itp341.bhatia.shamit.polease_final_project.model.User;

/**
 * Created by Shamit on 12/4/17.
 */

public class ListFragment extends Fragment{

    private static final String TAG = ListFragment.class.getSimpleName();

    ListView mainListView;
    Button buttonNewCase;

    List<Case> casesList = new ArrayList<>();

    private DatabaseReference myRef;
    private CaseListAdapter adapter;

    private User myUser;
    // private CaseListAdapter adapter;

    public ListFragment() {
        // Required empty default constructor
    }

    public static ListFragment newInstance(User currUser) {
        Bundle args = new Bundle();
        args.putSerializable("userTagExtra", currUser);
        ListFragment f = new ListFragment();
        f.setArguments(args);
        return f;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.list_view_cases, container, false);

        buttonNewCase = v.findViewById(R.id.btnStartNewCase);
        mainListView = v.findViewById(R.id.listView1);

        myRef = FirebaseDatabase.getInstance().getReference().child(myUser.getUsername()).child("Cases");

        // set adapter to cases list
        adapter = new CaseListAdapter(getActivity(), R.layout.layout_case, casesList);

        // get list of cases via firebase

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot snap : dataSnapshot.getChildren()){

                    String title = snap.child("caseTitle").getValue().toString();
                    String descr = snap.child("caseDescription").getValue().toString();
                    boolean status = (boolean) snap.child("caseStatus").getValue();
                    Case myCase = new Case(title, descr, status);

                    casesList.add(myCase);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        buttonNewCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), CaseActivity.class);
                i.putExtra("userTagNew",myUser);
                startActivityForResult(i, 0);
            }
        });
        return v;
    }

    public class CaseListAdapter extends ArrayAdapter<Case>{

        public CaseListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Case> objects) {
            super(context, resource, objects);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            //step 1 -- inflate view (row) if necessary
            if (convertView == null) {      //this means row has NEVER been created
                convertView = getActivity().getLayoutInflater().inflate(R.layout.layout_case, null);
            }
            //step 2 -- get references to XML views in the row
            ImageView image = convertView.findViewById(R.id.imageViewOnList);
            TextView titleText = convertView.findViewById(R.id.caseTitleOnList);
            TextView descriptionText = convertView.findViewById(R.id.caseDescOnList);

            //step 3 -- get the new model data
            Case c = getItem(position);  //getting the specified Case from the adapter

            //step 4 -- load the data from the model to the view
            // figure out getting image

            titleText.setText(c.getCaseTitle());
            descriptionText.setText(c.getCaseDescription());
            image.setImageBitmap(c.getImageEvidence());

            return convertView;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        myUser = (User)args.getSerializable("userTagExtra");

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK){
            adapter.notifyDataSetChanged();
        }
    }
}
