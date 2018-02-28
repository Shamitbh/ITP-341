package itp341.bhatia.shamit.a8;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Shamit on 10/22/17.
 */

public class UnitFragment extends Fragment {

    // References to widgets
    private EditText editTextVal;
    private RadioGroup fromRadioGroup;
    private RadioGroup toRadioGroup;
    private Button convertButton;
    private TextView resultVal;

    // private instance variables
    private String unitsVal;
    private double unitsValDouble;
    private double conversionNum;
    private double endResult;
    private String fromUnits = "none";
    private String toUnits = "none";

    public UnitFragment() {
        // Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_unit, container, false);

        // Initialize widgets
        editTextVal = (EditText) v.findViewById(R.id.editTextUnits);
        fromRadioGroup = (RadioGroup) v.findViewById(R.id.unitRadioGroupFrom);
        toRadioGroup = (RadioGroup) v.findViewById(R.id.unitRadioGroupTo);
        convertButton = (Button) v.findViewById(R.id.convertBtn);
        resultVal = (TextView) v.findViewById(R.id.resultNumber);

        fromRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch(i){
                    case R.id.cmFrom:
                        fromUnits = getResources().getString(R.string.centimeters);
                        break;
                    case R.id.meterFrom:
                        fromUnits = getResources().getString(R.string.meters);
                        break;
                    case R.id.feetFrom:
                        fromUnits = getResources().getString(R.string.feet);
                        break;
                    case R.id.milesFrom:
                        fromUnits = getResources().getString(R.string.miles);
                        break;
                    case R.id.kmFrom:
                        fromUnits = getResources().getString(R.string.kilometers);
                        break;
                    default:
                        fromUnits = getResources().getString(R.string.none);
                        break;
                }
            }
        });

        toRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch(i) {
                    case R.id.cmTo:
                        toUnits = getResources().getString(R.string.centimeters);
                        break;
                    case R.id.meterTo:
                        toUnits = getResources().getString(R.string.meters);
                        break;
                    case R.id.feetTo:
                        toUnits = getResources().getString(R.string.feet);
                        break;
                    case R.id.milesTo:
                        toUnits = getResources().getString(R.string.miles);
                        break;
                    case R.id.kmTo:
                        toUnits = getResources().getString(R.string.kilometers);
                        break;
                    default:
                        toUnits = getResources().getString(R.string.none);
                        break;
                }
            }
        });


        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextVal.getText().toString().equals("")){
                    // User didn't enter anything. Do nothing!
                    resultVal.setText("");
                }
                else{
                    unitsVal = editTextVal.getText().toString();
                    // get value in double form
                    unitsValDouble = Double.valueOf(unitsVal);

                    // Check whether user clicked radio buttons or not
                    if (fromUnits.equals(getResources().getString(R.string.none)) ||
                            toUnits.equals(getResources().getString(R.string.none))) {
                        // Don't convert because user hasn't selected both radio buttons
                        // Do nothing!
                        resultVal.setText("");
                    }
                    // Otherwise check all different options and change conversionNum accordingly
                    if (fromUnits.equals(getResources().getString(R.string.centimeters)) &&
                            toUnits.equals(getResources().getString(R.string.centimeters))){
                        conversionNum = 1;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.centimeters)) &&
                            toUnits.equals(getResources().getString(R.string.meters))){
                        conversionNum = 0.01;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.centimeters)) &&
                            toUnits.equals(getResources().getString(R.string.feet))){
                        conversionNum = 0.0328;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.centimeters)) &&
                            toUnits.equals(getResources().getString(R.string.miles))){
                        conversionNum = 0.00000621;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.centimeters)) &&
                            toUnits.equals(getResources().getString(R.string.kilometers))){
                        conversionNum = 0.00001;
                    }

                    // Check meters from
                    if (fromUnits.equals(getResources().getString(R.string.meters)) &&
                            toUnits.equals(getResources().getString(R.string.centimeters))){
                        conversionNum = 100;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.meters)) &&
                            toUnits.equals(getResources().getString(R.string.meters))){
                        conversionNum = 1;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.meters)) &&
                            toUnits.equals(getResources().getString(R.string.feet))){
                        conversionNum = 3.2808;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.meters)) &&
                            toUnits.equals(getResources().getString(R.string.miles))){
                        conversionNum = 0.000621;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.meters)) &&
                            toUnits.equals(getResources().getString(R.string.kilometers))){
                        conversionNum = 0.01;
                    }

                    // Check feet from
                    if (fromUnits.equals(getResources().getString(R.string.feet)) &&
                            toUnits.equals(getResources().getString(R.string.centimeters))){
                        conversionNum = 30.48;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.feet)) &&
                            toUnits.equals(getResources().getString(R.string.meters))){
                        conversionNum = 0.3048;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.feet)) &&
                            toUnits.equals(getResources().getString(R.string.feet))){
                        conversionNum = 1;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.feet)) &&
                            toUnits.equals(getResources().getString(R.string.miles))){
                        conversionNum = 0.000189;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.feet)) &&
                            toUnits.equals(getResources().getString(R.string.kilometers))){
                        conversionNum = 0.000304;
                    }

                    // Check miles from
                    if (fromUnits.equals(getResources().getString(R.string.miles)) &&
                            toUnits.equals(getResources().getString(R.string.centimeters))){
                        conversionNum = 160934;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.miles)) &&
                            toUnits.equals(getResources().getString(R.string.meters))){
                        conversionNum = 1609.34;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.miles)) &&
                            toUnits.equals(getResources().getString(R.string.feet))){
                        conversionNum = 5280;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.miles)) &&
                            toUnits.equals(getResources().getString(R.string.miles))){
                        conversionNum = 1;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.miles)) &&
                            toUnits.equals(getResources().getString(R.string.kilometers))){
                        conversionNum = 1.60934;
                    }

                    // Check kilometers from
                    if (fromUnits.equals(getResources().getString(R.string.kilometers)) &&
                            toUnits.equals(getResources().getString(R.string.centimeters))){
                        conversionNum = 100000;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.kilometers)) &&
                            toUnits.equals(getResources().getString(R.string.meters))){
                        conversionNum = 1000;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.kilometers)) &&
                            toUnits.equals(getResources().getString(R.string.feet))){
                        conversionNum = 3280.84;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.kilometers)) &&
                            toUnits.equals(getResources().getString(R.string.miles))){
                        conversionNum = 0.62137;
                    }
                    if (fromUnits.equals(getResources().getString(R.string.kilometers)) &&
                            toUnits.equals(getResources().getString(R.string.kilometers))){
                        conversionNum = 1;
                    }

                    // Now we have the correct conversion number, so get result!
                    endResult = unitsValDouble*conversionNum;
                    resultVal.setText(Double.toString(endResult));
                }
            }
        });

        return v;
    }
}
