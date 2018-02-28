// Shamit Bhatia
// Shamitbh@usc.edu
// ITP 341
// Fall 2017


package itp341.exercises.week4pizzaorder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MainActivity extends AppCompatActivity {

    // TAG
    private static final String TAG = MainActivity.class.getSimpleName();

    //  variables for widgets
    CheckBox checkPepperoni;
    CheckBox checkPineapple;
    CheckBox checkTofu;
    RadioGroup radioGroupSize;
    SeekBar seekBarNumPizzas;
    TextView textNumPizzasSeekBarProgress;
    Spinner spinnerSpecials;
    TextView textOrderDisplay;
    EditText editName;

    //TODO instance variables


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get references to widgets


        //TODO create EditorActionListener


        //TODO create checkbox listeners


        //TODO create radiogroup listener


        //TODO seekbar listener


        //TODO create spinner listener


        //TODO generate "human-readable" description of pizza and write to textView

    }
    public void displayPizzaOrder() {

    }

    //TODO determine what qualifies as a valid order
    public boolean isOrderValid() {
        return false;
    }


}
