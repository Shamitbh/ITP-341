package itp341.bhatia.shamit.a6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/**
 * Created by Shamit on 10/2/17.
 */

public class NameActivity extends AppCompatActivity {

    // Widgets
    EditText nameEdit;
    Button setChangesName;


    // instance variables
    private String mainNameText = "";
    private String nameText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        mainNameText = getIntent().getStringExtra(MainActivity.NAME_VALUE);

        nameEdit = (EditText)findViewById(R.id.nameEditText);
        setChangesName = (Button)findViewById(R.id.btnSetChangesName);

        setChangesName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameText = nameEdit.getText().toString();
                // check the user input name and what the correct name should be
                if (mainNameText.equals(nameText)) {
                    setResult(1,getIntent());
                    finish();
                }
                else {
                    setResult(0,getIntent());
                    finish();
                }
            }
        });

    }
}
