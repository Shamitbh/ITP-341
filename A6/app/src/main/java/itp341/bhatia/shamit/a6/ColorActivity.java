package itp341.bhatia.shamit.a6;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Shamit on 9/28/17.
 */

public class ColorActivity extends AppCompatActivity{

    // variables for widgets
    SeekBar rSeek;
    SeekBar gSeek;
    SeekBar bSeek;
    TextView rText;
    TextView gText;
    TextView bText;
    TextView previewColor;
    Button setChangesColor;



    // instance variables
    private int rValue = 0;
    private int gValue = 0;
    private int bValue = 0;

    // variables to hold values passed from main
    private int mainRValue = 0;
    private int mainGValue = 0;
    private int mainBValue = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mainRValue = getIntent().getIntExtra(MainActivity.RED_VALUE,0);
        mainGValue = getIntent().getIntExtra(MainActivity.GREEN_VALUE,0);
        mainBValue = getIntent().getIntExtra(MainActivity.BLUE_VALUE,0);

        rSeek = (SeekBar)findViewById(R.id.r_seekbar);
        gSeek = (SeekBar)findViewById(R.id.g_seekbar);
        bSeek = (SeekBar)findViewById(R.id.b_seekbar);
        rSeek.setMax(255);
        gSeek.setMax(255);
        bSeek.setMax(255);
        rText = (TextView)findViewById(R.id.r_value);
        gText = (TextView)findViewById(R.id.g_value);
        bText = (TextView)findViewById(R.id.b_value);
        previewColor = (TextView)findViewById(R.id.preview_color);
        setChangesColor = (Button)findViewById(R.id.btnSetChangesColor);


        rSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                rValue = i;
                rText.setText("R: "+Integer.toString(rValue));
                previewColor.setBackgroundColor(Color.rgb(rValue,gValue,bValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        gSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                gValue = i;
                gText.setText("G: "+Integer.toString(gValue));
                previewColor.setBackgroundColor(Color.rgb(rValue,gValue,bValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        bSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                bValue = i;
                bText.setText("B: "+Integer.toString(bValue));
                previewColor.setBackgroundColor(Color.rgb(rValue,gValue,bValue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        setChangesColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Compare rgb values, set boolean to true
                if (rValue == mainRValue && gValue == mainGValue && bValue == mainBValue){
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
