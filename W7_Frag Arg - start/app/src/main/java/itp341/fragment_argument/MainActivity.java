package itp341.fragment_argument;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    //TODO add
    Spinner spinner;
    Button buttonSwap;
    boolean loadNyan = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinner);

//
//
//        FragmentManager fm = getSupportFragmentManager();
//        Fragment sampleFragment = fm.findFragmentById(R.id.fragment_container);
//
//        if (sampleFragment == null) {
//            if (!loadNyan)
//                sampleFragment = new FragmentDoodler();
//            else
//                sampleFragment = new FragmentNyan();
//            loadNyan = !loadNyan;
//            FragmentTransaction fragmentTransaction = fm.beginTransaction();
//            fragmentTransaction.add(R.id.fragment_container, sampleFragment);
//            fragmentTransaction.commit();
//
//        }



        // TODO: update
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "Spinner id: " + i);

                if (view != null) {
                    // TODO: add fragment
                    FragmentManager fm = getSupportFragmentManager(); // same as before
                    // Fragment f = new FragmentCharacter(); // NOOOOOOOOOOOOOOOOOOO - we don't instantiate fragments anymore
                    // Becuase we have the newInstance method that calls factory

                    // Get character name from the spinner textview
                    String character = ((TextView) view).getText().toString();
                    // use factory to make a fragment
                    Fragment f = FragmentCharacter.newInstance(character);
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fragment_container, f);
                    ft.commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
