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
public class DoodlerFragment extends Fragment {

    private Button buttonJump;
    private ImageView image;

    public DoodlerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_doodler, container, false);

        image = (ImageView) v.findViewById(R.id.image);
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
