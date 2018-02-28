package itp341.bhatia.shamit.w2_d1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Step 1 -- need variable to store view
    private Button buttonAgree;
    private Button buttonStronglyAgree;
    private TextView textViewStronglyAgree;
    private EditText editableText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Step 2 -- get reference to the actual instantiated ("inflated") object on the screen
        buttonAgree = (Button) findViewById(R.id.button_agree);
        buttonStronglyAgree = (Button) findViewById(R.id.button_strongly_agree);
        textViewStronglyAgree = (TextView) findViewById(R.id.textview_greeting);
        editableText = (EditText) findViewById(R.id.edit_text_strongly_agree);

        // Step 3
        buttonAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Step 4 - what happens when the button is clicked
                // Toast.makeText(getApplicationContext(), "Thanks for agreeing that Mocha is adorable", Toast.LENGTH_SHORT).show();
                textViewStronglyAgree.setText(R.string.text_default_mocha);
            }
        });

        buttonStronglyAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Step 4 - what happens when the button is clicked
                // Toast.makeText(getApplicationContext(), "Aww! Thanks I STRONGLY AGREE!", Toast.LENGTH_SHORT).show();

                // Can just make a string variable to make more readable
                    // String response = editableText.getText().toString();
                    // textViewStronglyAgree.setText(response);

                textViewStronglyAgree.setText(editableText.getText().toString());
            }
        });

    }
}
