package itp341.fragment_argument;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class FragmentCharacter extends Fragment {

    // key for the bundle
    public static final String BUNDLE_CODE = "BUNDLE_CODE";
    public static final String CODE_NYAN = "nyan";
    public static final String CODE_DOODLER = "doodler";

    private String characterCode;

    Button buttonJump;
    ImageView image;
    TextView textName;


    public FragmentCharacter() {
        // dont put anything here
        // Required empty public constructor
    }

    // static fragment method aka FACTORY
    public static FragmentCharacter newInstance(String code) { // code represents nyan or doodler or whatever
        // step 0: Create the bundle
        Bundle args = new Bundle();
        args.putString(BUNDLE_CODE, code);

        // Step 1: Create an empty fragment
        FragmentCharacter fc = new FragmentCharacter();

        // Step 2: Add the bundle data to the fragment
        // Note: If we were launching different activities, would also need to get data from intent...
        // Since we're doing fragments, we don't have to
        fc.setArguments(args);

        // Step 3: Return the fragment
        return fc;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        characterCode = getArguments().getString(BUNDLE_CODE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_nyan, container, false);
        image  = (ImageView) v.findViewById(R.id.image);
        buttonJump = (Button) v.findViewById(R.id.buttonJump);
        textName = (TextView) v.findViewById(R.id.textName);
        buttonJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumpAnimation(image);
            }
        });

        loadCharacter(); // method we just made up
        return v;
    }

    private void loadCharacter() {
        switch (characterCode){
            case CODE_DOODLER:
                textName.setText(R.string.character_name_doodler);
                image.setImageResource(R.drawable.doodler);
                break;
            case CODE_NYAN:
                textName.setText(R.string.character_name_nyan);
                image.setImageResource(R.drawable.nyan);
                break;
            default:
                // nothing necessary
        }
    }

    public void jumpAnimation(Object o){
        ObjectAnimator heightAnimator = ObjectAnimator.ofFloat(o,"y", 0 , 50).setDuration(500);
        //Animator places object at 0 and takes it 50 from the top view
        //Pressing quickly creates jumping illusion
        //Adding more int values such as 0, 50, 0 will animate from 0, 50, to 0.
        heightAnimator.start();
    }

}
