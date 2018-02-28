package itp341.bhatia.shamit.polease_final_project;

import android.graphics.Picture;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Button;

/**
 * Created by Shamit on 12/4/17.
 */

public class PictureFragment extends Fragment {

    Button btnBackBtn;

    public PictureFragment() {
        // Required empty default constructor
    }

    public static PictureFragment newInstance() {
        Bundle args = new Bundle();
        PictureFragment f = new PictureFragment();
        f.setArguments(args);
        return f;
    }


}
