package itp341.bhatia.shamit.a6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Shamit on 10/2/17.
 */

public class WinLoseActivity extends AppCompatActivity {

    // Widget references
    TextView winOrLose;

    // Instance variables
    private int numPuzzlesCompleted = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win_lose);

        numPuzzlesCompleted = getIntent().getIntExtra(MainActivity.WIN_LOSE_VALUE,0);

        winOrLose = (TextView)findViewById(R.id.win_or_lose);

        if (numPuzzlesCompleted == 3) {
            winOrLose.setText(getText(R.string.youWin));
        }

    }
}
