package itp341.week7_review_frag_final;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textNumVotes;
    RadioGroup radioGroupVote;

    // For savedInstance state
    public final static String BUNDLE_NUM_VOTES = "BUNDLE_NUM_VOTES";
    int numVotes = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radioGroupVote = (RadioGroup) findViewById(R.id.radio_group_vote);
        textNumVotes = (TextView) findViewById(R.id.text_num_votes);


        if (savedInstanceState != null) {
            numVotes = savedInstanceState.getInt(BUNDLE_NUM_VOTES, 0);
        }
        // load numVotes on screen
        textNumVotes.setText(Integer.toString(numVotes));

        // Fragment manager - system service that android provides where we can access fragments, swap, load, etc.
        FragmentManager fm = getSupportFragmentManager();
        // Find the specific fragment by using the ID
        Fragment f = fm.findFragmentById(R.id.fragment_container);
        // If f = null, it's the first time
        if (f == null) {
            f = new VoteFragment();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragment_container, f);
            ft.commit();
        }


        radioGroupVote.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int i) {
                FragmentManager fm = getSupportFragmentManager();
                Fragment f;
                FragmentTransaction ft;
                switch (i) {
                    case R.id.radio_pirate:
                        numVotes++;
                        textNumVotes.setText(Integer.toString(numVotes));


                        f = MochaFragment.newInstance(MochaFragment.ARG_PIRATE);
                        ft = fm.beginTransaction();
                        ft.replace(R.id.fragment_container, f);
                        ft.commit();

                        radioGroupVote.clearCheck(); // to prevent "votes" on rotation b/c radio group still selected
                        break;
                    case R.id.radio_wolf:
                        numVotes++;
                        textNumVotes.setText(Integer.toString(numVotes));
                        f = MochaFragment.newInstance(MochaFragment.ARG_WOLF);
                        ft = fm.beginTransaction();
                        ft.replace(R.id.fragment_container, f);
                        ft.commit();

                        radioGroupVote.clearCheck();
                        break;
                }
            }
        });

    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BUNDLE_NUM_VOTES, numVotes);
    }
}
