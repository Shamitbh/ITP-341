package itp341.fragment_exercise;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NyanFragment extends Fragment { // STEP 2: Build the fragment class and make the view

    private Button buttonJump;
    private ImageView image;

    public NyanFragment() {
        // Required empty public constructor
    }

    // for this project, we DON'T NEED onCreate

    // onCreateView is for all UI tasks
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // to load UI for fragments
        View v = inflater.inflate(R.layout.fragment_nyan, container, false);
        // View v represents as an object the layout file for fragment_nyan
        image = (ImageView) v.findViewById(R.id.image); // NEED TO USE v.findViewByID because it's in the View v
        buttonJump = (Button) v.findViewById(R.id.buttonJump);

        buttonJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jump.animation(image);
            }
        });

        return v;
    }

}
