package itp341.week7_review_frag_final;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MochaFragment extends Fragment {

    // key for the bundle
    private String characterCode;

    public static int ARG_WOLF = 0;
    public static int ARG_PIRATE = 1;

    public static final String MOCHA_ARG_CODE = "MOCHA_ARG_CODE";


    public MochaFragment() {
        // Required empty public constructor
    }

    // static fragment method aka FACTORY
    public static Fragment newInstance(int code) {
        Fragment f = new MochaFragment();
        // step 0: Create the bundle
        Bundle args = new Bundle();
        args.putInt(MOCHA_ARG_CODE, code);

        // Step 2: Add the bundle data to the fragment
        // Note: If we were launching different activities, would also need to get data from intent...
        // Since we're doing fragments, we don't have to
        f.setArguments(args);

        // Step 3: Return the fragment
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        int code = getArguments().getInt(MOCHA_ARG_CODE);
        View v;
        if (code == R.id.radio_pirate){
            v = inflater.inflate(R.layout.fragment_pirate, container, false);
        }
        else{
            v = inflater.inflate(R.layout.fragment_wolf, container, false);
        }
        return v;
    }

}
