package itp341.bhatia.shamit.polease_final_project;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

import itp341.bhatia.shamit.polease_final_project.model.Case;
import itp341.bhatia.shamit.polease_final_project.model.User;

/**
 * Created by Shamit on 12/4/17.
 */

public class CaseFragment extends Fragment {

    EditText editCaseTitle;
    EditText editCaseDescription;
    Button buttonTakePicture;
    Button buttonFileCase;
    ImageView imageEvidence;
    Bitmap bitmap;

    Case newCase = null;
    User currUser = null;
    private int numCases = 0;

    // Reference to firebase database
    private DatabaseReference specificUserDatabase;

    public CaseFragment() {
        // Required empty default constructor
    }

    public static CaseFragment newInstance(User currUser) {
        Bundle args = new Bundle();
        args.putSerializable("userTagNewExtra", currUser);
        CaseFragment f = new CaseFragment();
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        currUser = (User) args.getSerializable("userTagNewExtra");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.case_text, container, false);

        // point to root directory of database
        specificUserDatabase = FirebaseDatabase.getInstance().getReference().child(currUser.getUsername());

        editCaseTitle = v.findViewById(R.id.edit_case_title);
        editCaseDescription = v.findViewById(R.id.edit_case_description);
        buttonTakePicture = v.findViewById(R.id.btn_take_picture);
        buttonFileCase = v.findViewById(R.id.btn_file_case);
        imageEvidence = v.findViewById(R.id.image_evidence);

        buttonTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

        buttonFileCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // make a case object
                String caseTitle = editCaseTitle.getText().toString();
                String caseDescription = editCaseDescription.getText().toString();

                // Create case objects based on image or not
                if (bitmap != null) {
                    newCase = new Case(caseTitle, caseDescription, bitmap, true);
                }else{
                    newCase = new Case(caseTitle, caseDescription, true);
                }

                Log.d("TAG", newCase.getCaseTitle());
                // add this case to the user
                Log.d("TAG", currUser.getUsername());
                Log.d("SIZE", Integer.toString(currUser.getListOfCases().size()));
                // add this users cases to firebase
                currUser.getListOfCases().add(newCase);

                Log.d("TAG", Integer.toString(currUser.getListOfCases().size()));
                specificUserDatabase.child("Cases").push().setValue(newCase);
                // specificUserDatabase.child("Cases").child("case"+ Integer.toString(currUser.getListOfCases().size())).setValue(newCase);

                getActivity().setResult(Activity.RESULT_OK);
                getActivity().finish();
            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK){
            bitmap = (Bitmap)data.getExtras().get("data");
            imageEvidence.setImageBitmap(bitmap);
        }
    }
}
