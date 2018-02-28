package itp341.bhatia.shamit.polease_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import itp341.bhatia.shamit.polease_final_project.model.User;

/**
 * Created by Shamit on 12/4/17.
 */

public class ListActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        User currUser = (User) i.getSerializableExtra("userTag");

        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.frame_container);

        if (f == null ) {
            f = ListFragment.newInstance(currUser);
        }
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, f);
        fragmentTransaction.commit();
    }
}
