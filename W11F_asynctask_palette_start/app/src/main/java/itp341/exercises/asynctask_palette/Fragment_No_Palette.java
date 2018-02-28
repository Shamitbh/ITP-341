package itp341.exercises.asynctask_palette;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import itp341.exercises.asynctask_palette.model.Shiba;

/*
    This is an example not using palette
 */
public class Fragment_No_Palette extends Fragment {
    EditText mEditName;
    Spinner mSpinnerColor;
    EditText mEditAge;
    Button mButtonAdd;
    ListView mListview;
    ImageView mImageView;

    ArrayList<Shiba> mDogList;
    ArrayAdapter<Shiba> mAdapter;


    public Fragment_No_Palette() {
        // Required empty public constructor
    }


    public static Fragment_No_Palette newInstance() {
        Bundle args = new Bundle();

        Fragment_No_Palette f = new Fragment_No_Palette();

        return f;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        mEditName = (EditText) v.findViewById(R.id.editName);
        mSpinnerColor = (Spinner) v.findViewById(R.id.spinnerColor);
        mEditAge = (EditText) v.findViewById(R.id.editAge);
        mButtonAdd = (Button) v.findViewById(R.id.buttonAdd);
        mListview = (ListView) v.findViewById(R.id.listView);
        mImageView = (ImageView) v.findViewById(R.id.imageView);

        //TODO edit here
        mDogList = new ArrayList<>();
        mAdapter = new ArrayAdapter<Shiba>(getActivity(), android.R.layout.simple_list_item_1, mDogList);
        mListview.setAdapter(mAdapter);


        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Shiba s = new Shiba();
                s.setName(mEditName.getText().toString());

                String tempInt = mEditAge.getText().toString();
                if (tempInt.equals(""))
                    s.setAge(0);
                else
                    s.setAge(Integer.parseInt(tempInt));


                s.setColor(mSpinnerColor.getSelectedItem().toString());

                mDogList.add(s);
                mAdapter.notifyDataSetChanged();
                Log.d("Shiba", s.toString());
                Log.d("Shiba array", mDogList.toString());
            }
        });

        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Shiba s = mDogList.get(i);
                mEditName.setText(s.getName());
                mEditAge.setText(String.valueOf(s.getAge()));
                Log.d("Shiba List", s.toString());

                int resId;

                if (s.getColor().equalsIgnoreCase("black")) {
                    resId = R.drawable.shiba_black;
                } else if (s.getColor().equalsIgnoreCase("sesame")) {
                    resId = R.drawable.shiba_sesame;
                } else {
                    resId = R.drawable.shiba_white;
                }

                mImageView.setImageResource(resId);
            }
        });


        return v;
    }

}


