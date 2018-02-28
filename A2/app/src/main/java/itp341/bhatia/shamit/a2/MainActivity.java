package itp341.bhatia.shamit.a2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {
    // Step 1 - make variables for buttons
    private Button buttonHat;
    private Button buttonHoodie;


    // Have variables to keep track of user clicks for both buttons
    private int counterHoodie = 1;
    private int counterHat = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Step 2 - get reference to the actual instantiated ("inflated") object on the screen
        buttonHat = (Button) findViewById(R.id.button_hat);
        buttonHoodie = (Button) findViewById(R.id.button_hoodie);

        buttonHat.setOnClickListener(new ButtonListener());
        buttonHoodie.setOnClickListener(new ButtonListener());
    }

    // Extra credit: Using only one eventHandler method that responds to multiple button clicks
    class ButtonListener implements OnClickListener {

        @Override public void onClick(View v) {
            // Switch statement to identify between the buttons
            switch (v.getId()) {
                // Case for button "hoodie"
                case R.id.button_hoodie:
                    // Make string variable with string output and counterHoodie
                    if (counterHoodie == 1){
                        // print time not times
                        String outputHoodie = getString(R.string.hoodieClick)+counterHoodie+getString(R.string.time);
                        Toast.makeText(getApplicationContext(), outputHoodie, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        // print times not time
                        String outputHoodie = getString(R.string.hoodieClick)+counterHoodie+getString(R.string.times);
                        Toast.makeText(getApplicationContext(), outputHoodie, Toast.LENGTH_SHORT).show();
                    }
                    counterHoodie++;
                    break;
                // Case for button "hat"
                case R.id.button_hat:
                    // Make string variable with string output and counterHat
                    if (counterHat == 1){
                        // print time not times
                        String outputHat = getString(R.string.hatClick)+counterHat+getString(R.string.time);
                        Toast.makeText(getApplicationContext(), outputHat, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        // print times not time
                        String outputHat = getString(R.string.hatClick)+counterHat+getString(R.string.times);
                        Toast.makeText(getApplicationContext(), outputHat, Toast.LENGTH_SHORT).show();
                    }
                    counterHat++;
                    break;
                default:
                    break;
            }
        }
    }

}
