package itp341.bhatia.shamit.a8;


import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.support.v4.app.Fragment;


/**
 * Created by Shamit on 10/22/17.
 */

public class TipFragment extends Fragment {

    // References to widgets
    EditText editBillAmount;
    TextView textNumPercentage;
    SeekBar seekBarPercent;
    TextView textNumTip;
    TextView textNumTotal;
    Spinner spinnerSplit;
    TextView textPerPerson;
    TextView textNumPerPerson;


    // Private instance variables
    private int tipPercentage = 0;
    private double tipDollar = 0;
    private double totalDollar = 0;
    private double billAmount = 0;
    private double perPerson = 0;
    private String billAmountString = "";


    public TipFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_tip, container, false);

        // Get references to widgets
        editBillAmount = (EditText)v.findViewById(R.id.bill_edit_text);
        textNumPercentage = (TextView)v.findViewById(R.id.percentNum);
        seekBarPercent = (SeekBar)v.findViewById(R.id.seekbar);
        textNumTip = (TextView)v.findViewById(R.id.tipCount);
        textNumTotal = (TextView)v.findViewById(R.id.totalCount);
        spinnerSplit = (Spinner)v.findViewById(R.id.spinner);
        textPerPerson = (TextView)v.findViewById(R.id.perPerson);
        textNumPerPerson = (TextView)v.findViewById(R.id.perPersonCount);



        // EditText listener for bill amount
        editBillAmount.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//                // reset values
//                tipDollar = 0;
//                totalDollar = 0;
//                billAmount = 0;
                // set values
                if (editBillAmount.getText().toString().equals("")){
                    billAmountString = "0";
                }
                else{
                    billAmountString = editBillAmount.getText().toString();
                    billAmount = Double.valueOf(billAmountString);
                    tipDollar = billAmount * tipPercentage/100;
                    totalDollar = billAmount + tipDollar;
                    textNumTip.setText("$"+Double.toString(tipDollar));
                    textNumTotal.setText("$"+Double.toString(totalDollar));
                }
                return true;
            }
        });


        // Seek bar listener to update tip percentage
        seekBarPercent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tipPercentage = i;
                textNumPercentage.setText(Integer.toString(i)+"%");
                tipDollar = billAmount * tipPercentage/100;
                totalDollar = billAmount + tipDollar;
                textNumTip.setText("$"+Double.toString(tipDollar));
                textNumTotal.setText("$"+Double.toString(totalDollar));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Spinner listener to check for bill splits
        spinnerSplit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String splitBillSelection = adapterView.getItemAtPosition(i).toString();

                switch (splitBillSelection) {
                    case "No":
                        textPerPerson.setVisibility(View.INVISIBLE);
                        textNumPerPerson.setVisibility(View.INVISIBLE);
                        break;
                    case "2 ways":
                        textPerPerson.setVisibility(View.VISIBLE);
                        perPerson = totalDollar/2.00;
                        // format so only 2 decimal places show
                        String perPersonString2 = String.format("%.2f", perPerson);
                        textNumPerPerson.setText(perPersonString2);
                        textNumPerPerson.setVisibility(View.VISIBLE);
                        break;
                    case "3 ways":
                        textPerPerson.setVisibility(View.VISIBLE);
                        perPerson = totalDollar/3.00;
                        // format so only 2 decimal places show
                        String perPersonString3 = String.format("%.2f", perPerson);
                        textNumPerPerson.setText(perPersonString3);
                        textNumPerPerson.setVisibility(View.VISIBLE);
                        break;
                    case "4 ways":
                        textPerPerson.setVisibility(View.VISIBLE);
                        perPerson = totalDollar/4.00;
                        // format so only 2 decimal places show
                        String perPersonString4 = String.format("%.2f", perPerson);
                        textNumPerPerson.setText(perPersonString4);
                        textNumPerPerson.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Since spinner starts as "No" for split bill, don't show per person info
                textPerPerson.setVisibility(View.INVISIBLE);
                textNumPerPerson.setVisibility(View.INVISIBLE);
            }
        });


        return v;
    }

}

