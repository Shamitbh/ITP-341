package itp341.fragment_exercise;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    Button buttonSwap;
    private boolean loadNyan = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSwap = (Button) findViewById(R.id.buttonSwap);

        // load a fragment initially
        // get the manager
        FragmentManager fm = getSupportFragmentManager();
        // instantiate OR use previous object of our fragment class
        Fragment f = fm.findFragmentById(R.id.fragment_container);

        if (f == null) { // means fragment doesn't exist
            // instantiate fragment then
            f = new NyanFragment();

            // Load fragment via transaction
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragment_container, f);
            ft.commit();
            loadNyan = false;
        }



        buttonSwap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                Fragment f = null;
                if (loadNyan == true){
                    f = new DoodlerFragment();
                }
                else{
                    f = new NyanFragment();
                }
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, f);
                ft.commit();
                loadNyan = !loadNyan;
            }
        });

    }
}
