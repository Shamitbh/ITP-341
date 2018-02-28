package itp341.w4pizzaorder_listener_final;

import android.os.Bundle;
import android.support.annotation.IdRes;
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

import org.w3c.dom.Text;

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
    private boolean wantsPepperoni = false;
    private boolean wantsPineapple = false;
    private boolean wantsTofu = false;
    private String name = "";
    private int numPizzas = 1;
    private String size = "";
    private String specials = "none";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relative);

        // get references to widgets
        checkPepperoni = (CheckBox) findViewById(R.id.check_pepperoni);
        checkPineapple = (CheckBox) findViewById(R.id.check_pineapple);
        checkTofu = (CheckBox) findViewById(R.id.check_tofu);
        radioGroupSize = (RadioGroup) findViewById(R.id.radio_group_size);
        seekBarNumPizzas = (SeekBar) findViewById(R.id.seekbar_num_pizzas);
        textNumPizzasSeekBarProgress = (TextView) findViewById(R.id.text_num_pizzas_seekbar_progress);
        spinnerSpecials = (Spinner) findViewById(R.id.spinner_specials);
        textOrderDisplay = (TextView) findViewById(R.id.text_order_display);
        editName = (EditText) findViewById(R.id.edit_name);

        //TODO create EditorActionListener
        editName.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                name = editName.getText().toString();
                return true;
            }
        });

        //TODO create checkbox listeners
        checkPineapple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true){
                    wantsPineapple = true;
                }
            }
        });

        checkPepperoni.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true){
                    wantsPepperoni = true;
                }
            }
        });

        checkTofu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true){
                    wantsTofu = true;
                }
            }
        });

        //TODO create radiogroup listener
        radioGroupSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch(i) {
                    case R.id.radio_small:
                        size = getResources().getString(R.string.label_small);
                        break;
                    case R.id.radio_medium:
                        size = getResources().getString(R.string.label_medium);
                        break;
                    case R.id.radio_large:
                        size = getResources().getString(R.string.label_large);
                        break;
                    default:
                }
                displayPizzaOrder();
            }
        });

        //TODO seekbar listener
        seekBarNumPizzas.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            // ONLY REALLY CARE ABOUT PROGRESS CHANGED
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // update the state of program
                numPizzas = i;
                // update text view on the side
                textNumPizzasSeekBarProgress.setText(Integer.toString(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //TODO create spinner listener


        //TODO generate "human-readable" description of pizza and write to textView

    }

    public void displayPizzaOrder() {
        // String Builder -> tool java provides that puts strings together
        StringBuilder output = new StringBuilder();

        // Check if order is valid otherwise set Text box that says, please complete form.
        output.append("Order for "+ name + "\nYou ordered ");
        output.append(numPizzas);
        output.append(" "+size+"pizza(s)");

        textOrderDisplay.setText(output);
        // textOrderDisplay.setText("Order for "+name+"\nYou ordered "+numPizzas+" "+size+" pizzas");
    }

    //TODO determine what qualifies as a valid order
    public boolean isOrderValid() {
        return false;
    }


}
