package itp341.bhatia.shamit.a8;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Shamit on 10/22/17.
 */

public class MoneyFragment extends Fragment {
    // References to widgets
    private EditText editTextValMoney;
    private Spinner fromSpinner;
    private Spinner toSpinner;
    private Button convertButtonMoney;
    private TextView resultValMoney;

    // private instance variables
    private String currencyVal;
    private double currencyValDouble;
    private double conversionNum;
    private double endResult;
    private String fromCurrency = "none";
    private String toCurrency = "none";

    public MoneyFragment() {
        // Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_money, container, false);

        // Initialize widgets
        editTextValMoney = (EditText) v.findViewById(R.id.editTextUnitsMoney);
        fromSpinner = (Spinner) v.findViewById(R.id.spinnerFrom);
        toSpinner = (Spinner) v.findViewById(R.id.spinnerTo);
        convertButtonMoney = (Button) v.findViewById(R.id.convertBtnMoney);
        resultValMoney = (TextView) v.findViewById(R.id.resultNumberMoney);

        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // get "from" text from the spinner
                fromCurrency = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // get "to" text from spinner
                toCurrency = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        convertButtonMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextValMoney.getText().toString().equals("")){
                    // User didn't enter anything. Do nothing!
                    resultValMoney.setText("");
                }
                else{
                    currencyVal = editTextValMoney.getText().toString();
                    // get value in double form
                    currencyValDouble = Double.valueOf(currencyVal);

                    // Check to see pairs of currency and change conversionNum accordingly
                    if (fromCurrency.equals(getResources().getString(R.string.USD)) &&
                            toCurrency.equals(getResources().getString(R.string.USD))){
                        conversionNum = 1;
                    }
                    if (fromCurrency.equals(getResources().getString(R.string.USD)) &&
                            toCurrency.equals(getResources().getString(R.string.yuan))){
                        conversionNum = 6.51;
                    }
                    if (fromCurrency.equals(getResources().getString(R.string.USD)) &&
                            toCurrency.equals(getResources().getString(R.string.euro))){
                        conversionNum = 0.90;
                    }

                    // Check from Yuan
                    if (fromCurrency.equals(getResources().getString(R.string.yuan)) &&
                            toCurrency.equals(getResources().getString(R.string.USD))){
                        conversionNum = 0.15;
                    }
                    if (fromCurrency.equals(getResources().getString(R.string.yuan)) &&
                            toCurrency.equals(getResources().getString(R.string.yuan))){
                        conversionNum = 1;
                    }
                    if (fromCurrency.equals(getResources().getString(R.string.yuan)) &&
                            toCurrency.equals(getResources().getString(R.string.euro))){
                        conversionNum = 0.14;
                    }

                    // Check from Euro
                    if (fromCurrency.equals(getResources().getString(R.string.euro)) &&
                            toCurrency.equals(getResources().getString(R.string.USD))){
                        conversionNum = 1.12;
                    }
                    if (fromCurrency.equals(getResources().getString(R.string.euro)) &&
                            toCurrency.equals(getResources().getString(R.string.yuan))){
                        conversionNum = 7.27;
                    }
                    if (fromCurrency.equals(getResources().getString(R.string.euro)) &&
                            toCurrency.equals(getResources().getString(R.string.euro))){
                        conversionNum = 1;
                    }


                    // Now we have the correct conversion number, so get result!
                    endResult = currencyValDouble*conversionNum;
                    resultValMoney.setText(Double.toString(endResult));
                }
            }
        });

        return v;
    }
}
