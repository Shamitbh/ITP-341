package itp341.bhatia.shamit.a6;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Shamit on 10/2/17.
 */

public class SizeActivity extends AppCompatActivity {

    // Widgets
    Spinner sizeSpinner;
    Button setChangesSize;

    // instance variables
    private String mainSizeValue = "";
    private String sizeValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);

        mainSizeValue = getIntent().getStringExtra(MainActivity.SIZE_VALUE);

        sizeSpinner = (Spinner)findViewById(R.id.spinnerSize);
        setChangesSize = (Button)findViewById(R.id.btnSetChangesSize);

        setChangesSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Compare rgb values, set boolean to true
                sizeValue = sizeSpinner.getSelectedItem().toString();
                if (sizeValue.equals(mainSizeValue)){
                    setResult(1,getIntent());
                    finish();
                }
                else{
                    setResult(0,getIntent());
                    finish();
                }
            }
        });

    }
}
