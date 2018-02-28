package itp341.bhatia.shamit.a9;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

import itp341.bhatia.shamit.a9.Model.Movie;
import itp341.bhatia.shamit.a9.Model.MovieSingleton;

/**
 * Created by Shamit on 11/2/17.
 */

public class CreateFragment extends Fragment {
    // References to widgets
    EditText editTitle;
    EditText editDescription;
    Spinner genreSpinner;
    EditText editURL;
    ImageView editImage;
    Button saveBtn;

    public CreateFragment(){
        // Required empty default constructor
    }

    public static CreateFragment newInstance() {
        Bundle args = new Bundle();
        CreateFragment f = new CreateFragment();
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_create, container, false);

        editTitle = (EditText) v.findViewById(R.id.editTextTitle);
        editDescription = (EditText) v.findViewById(R.id.editTextDescription);
        genreSpinner = (Spinner) v.findViewById(R.id.spinnerGenre);
        editURL = (EditText) v.findViewById(R.id.editTextURL);
        editImage = (ImageView) v.findViewById(R.id.imageViewCreate);
        saveBtn = (Button) v.findViewById(R.id.save_button);

        genreSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // depending on spinner item selected, change imageView dynamically
                switch (i){
                    case 0: // horror
                        editImage.setImageResource(R.drawable.horror);
                        break;
                    case 1: // sci-fi
                        editImage.setImageResource(R.drawable.scifi);
                        break;
                    case 2: // comedy
                        editImage.setImageResource(R.drawable.comedy);
                        break;
                    case 3: // drama
                        editImage.setImageResource(R.drawable.drama);
                        break;
                    case 4: //action
                        editImage.setImageResource(R.drawable.action);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movie m = new Movie();
                m.setTitle(editTitle.getText().toString());
                m.setDescription(editDescription.getText().toString());
                m.setURL(editURL.getText().toString());
                m.setGenre(genreSpinner.getSelectedItemPosition());

                MovieSingleton.get().addMovieObject(m);

                getActivity().setResult(Activity.RESULT_OK);
                getActivity().finish();

            }
        });

        return v;
    }


}

