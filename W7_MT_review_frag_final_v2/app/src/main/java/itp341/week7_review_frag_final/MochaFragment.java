package itp341.week7_review_frag_final;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MochaFragment extends Fragment {
    public static int ARG_WOLF = 0;
    public static int ARG_PIRATE = 1;
    public static String MOCHA_ARG_CODE = "MOCHA_ARG_CODE";


    public MochaFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(int code) {
        Fragment f = new MochaFragment();

        Bundle args = new Bundle();
        args.putInt(MOCHA_ARG_CODE, code);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        int code = getArguments().getInt(MOCHA_ARG_CODE);
        View v;
        if (code == ARG_PIRATE) {
            v = inflater.inflate(R.layout.fragment_pirate, container, false);
        }
        else{
            v = inflater.inflate(R.layout.fragment_wolf, container, false);
        }
        return v;
    }

}
