package itp341.bhatia.shamit.a6;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Tags used for intent putExtra
    public static final String RED_VALUE = "itp341.geoquiz.RED_VALUE";
    public static final String GREEN_VALUE = "itp341.geoquiz.GREEN_VALUE";
    public static final String BLUE_VALUE = "itp341.geoquiz.BLUE_VALUE";
    public static final String NUM_COMPLETE_PUZZLE = "itp341.geoquiz.NUM_COMPLETE_PUZZLE";

    public static final String SIZE_VALUE = "itp341.geoquiz.SIZE_VALUE";

    public static final String NAME_VALUE = "itp341.geoquiz.NAME_VALUE";

    public static final String WIN_LOSE_VALUE = "itp341.geoquiz.WIN_LOSE_VALUE";




    // Used to get widgets
    Button buttonRoom1;
    Button buttonRoom2;
    Button buttonRoom3;
    Button solve;
    TextView text1;
    TextView text2;
    TextView text3;

    // instance variables
    private int numPuzzleComplete = 0;
    private final int correctRedValue = 255;
    private final int correctGreenValue = 0;
    private final int correctBlueValue = 0;
    private final String correctSizeValue = "Large";
    private final String correctNameValue = "Drake";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRoom1 = (Button)findViewById(R.id.room1);
        buttonRoom2 = (Button)findViewById(R.id.room2);
        buttonRoom3 = (Button)findViewById(R.id.room3);
        solve = (Button)findViewById(R.id.solve);
        text1 = (TextView)findViewById(R.id.hint1);
        text2 = (TextView)findViewById(R.id.hint2);
        text3 = (TextView)findViewById(R.id.hint3);

        buttonRoom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ColorActivity.class);
                i.putExtra(RED_VALUE,correctRedValue);
                i.putExtra(GREEN_VALUE,correctGreenValue);
                i.putExtra(BLUE_VALUE,correctBlueValue);
                i.putExtra(NUM_COMPLETE_PUZZLE,numPuzzleComplete);
                startActivityForResult(i, 0);
            }
        });

        buttonRoom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SizeActivity.class);
                i.putExtra(SIZE_VALUE,correctSizeValue);
                i.putExtra(NUM_COMPLETE_PUZZLE,numPuzzleComplete);
                startActivityForResult(i, 1);
            }
        });

        buttonRoom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NameActivity.class);
                i.putExtra(NAME_VALUE,correctNameValue);
                i.putExtra(NUM_COMPLETE_PUZZLE,numPuzzleComplete);
                startActivityForResult(i, 2);
            }
        });

        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, WinLoseActivity.class);
                i.putExtra(WIN_LOSE_VALUE, numPuzzleComplete);
                startActivityForResult(i, 3);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check the first activity puzzle
        if (requestCode == 0) {
            if (resultCode == 1) {
                // solved color puzzle correctly
                if (numPuzzleComplete < 1) {
                    // increment numPuzzleCompleted
                    numPuzzleComplete++;
                    text1.setTextColor(Color.GREEN);
                }
            }
        }
        // check the second activity puzzle
        if (requestCode == 1) {
            if (resultCode == 1) {
                // solved size puzzle correctly
                if (numPuzzleComplete < 2 && numPuzzleComplete > 0) {
                    // increment numPuzzleCompleted
                    numPuzzleComplete++;
                    text2.setTextColor(Color.GREEN);
                }
            }
        }
        // check the third activity puzzle
        if (requestCode == 2) {
            if (resultCode == 1) {
                // solved the edit name puzzle correctly
                if (numPuzzleComplete < 3 && numPuzzleComplete > 1) {
                    // increment numPuzzleCompleted
                    numPuzzleComplete++;
                    text3.setTextColor(Color.GREEN);
                }
            }
        }
        // EXTRA CREDIT: When the user pressed back on the Win activity, reset the puzzle
        if (requestCode == 3) {
            // First check if user won the puzzle and reset only if they won..
            if (numPuzzleComplete == 3) {
                // Change text back to RED to indicate reset
                text1.setTextColor(Color.RED);
                text2.setTextColor(Color.RED);
                text3.setTextColor(Color.RED);
                // Set numPuzzleComplete back to 0
                numPuzzleComplete = 0;
            }
        }


    }
}
