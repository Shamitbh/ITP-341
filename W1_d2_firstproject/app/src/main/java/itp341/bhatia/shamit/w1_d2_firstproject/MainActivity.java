package itp341.bhatia.shamit.w1_d2_firstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    
    public void onClickWelcomeButton(View v) {
        // FOR NON-STATIC METHODS:
        // Toast t = new Toast();
        // t.makeText(...)

        // FOR STATIC METHODS: makeText is STATIC so...
        Toast.makeText(getApplicationContext(), "We are going to have a great semester", Toast.LENGTH_LONG).show();
        // Above will create a box with some text that will show on screen for some time
    }
    public void onClickWeeksButton(View v) {
        Toast.makeText(getApplicationContext(), "You're doing great so far!", Toast.LENGTH_LONG).show();
    }
}
