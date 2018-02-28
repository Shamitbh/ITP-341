package itp341.fragment_argument;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class FragmentDoodler extends Fragment {
    Button buttonJump;
    ImageView image;
    boolean loadNyan = true;

    public FragmentDoodler() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_doodler, container, false);
        image = (ImageView) v.findViewById(R.id.image);
        buttonJump = (Button) v.findViewById(R.id.buttonJump);
        buttonJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Jump.animation(image);
            }
        });

        return v;
    }

    public void jumpAnimation(Object o) {
        ObjectAnimator heightAnimator = ObjectAnimator.ofFloat(o, "y", 0, 50).setDuration(500);
        //Animator places object at 0 and takes it 50 from the top view
        //Pressing quickly creates jumping illusion
        //Adding more int values such as 0, 50, 0 will animate from 0, 50, to 0.
        heightAnimator.start();
    }

}
