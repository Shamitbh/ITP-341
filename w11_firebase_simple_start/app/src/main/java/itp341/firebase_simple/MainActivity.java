package itp341.firebase_simple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            String message = editText.getText().toString();

            // version 1
            // gets link to entire database
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            // get refrence to node to write
            DatabaseReference dbParent = database.getReference("Recipes");

            // generate new push id to store data so not needing to store in parent node everytime
            DatabaseReference dbNewRef = dbParent.push();
            // write to node but need to enable internet permissions (manifest)
            dbNewRef.setValue(message);

            editText.setText("");
            return false;
            }
        });
    }
}
