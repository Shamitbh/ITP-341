package itp341.bhatia.shamit.a7;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import itp341.bhatia.shamit.a7.Model.Card;
import itp341.bhatia.shamit.a7.Model.Ticket;

public class MainActivity extends AppCompatActivity {

    // private instance variables
    private int numTickets = 0;
    private String startLoc = "None";
    private String endLoc = "None";
    private String ticketType = "None";
    private String priority = "None";
    // Objects
    private Card mCard = new Card("None", "None");
    private Ticket mTicket = null;
    Intent cardInt;
    Intent orderInt;

    // references to widgets
    private TextView ticketCountTextView;
    private Spinner spinnerStartLoc;
    private Spinner spinnerEndLoc;
    private RadioGroup ticketTypeGroup;
    private RadioGroup priorityGroup;
    private Button btnUseCard;
    private Button btnVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ticketCountTextView = (TextView) findViewById(R.id.ticketCount);
        spinnerStartLoc = (Spinner) findViewById(R.id.spinnerStart);
        spinnerEndLoc = (Spinner) findViewById(R.id.spinnerEnd);
        ticketTypeGroup = (RadioGroup) findViewById(R.id.groupTkt);
        priorityGroup = (RadioGroup) findViewById(R.id.groupPriority);
        btnUseCard = (Button) findViewById(R.id.useCard);
        btnVerify = (Button) findViewById(R.id.verify);

        // Listeners for different radio groups, spinners, buttons, etc.

        // Spinners
        spinnerStartLoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                startLoc = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerEndLoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                endLoc = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Radio Groups
        ticketTypeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ticketType = ((RadioButton)ticketTypeGroup.findViewById(i)).getText().toString();
            }
        });

        priorityGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                priority = ((RadioButton)priorityGroup.findViewById(i)).getText().toString();
            }
        });

        // Buttons
        btnUseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cardInt = new Intent(MainActivity.this, CardActivity.class);
                cardInt.putExtra(CardActivity.CARD, mCard);
                startActivityForResult(cardInt,10);
            }
        });

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTicket = new Ticket(startLoc, endLoc, ticketType, priority);
                orderInt = new Intent(MainActivity.this, ViewOrderActivity.class);
                orderInt.putExtra(CardActivity.CARD, mCard);
                orderInt.putExtra(ViewOrderActivity.TICKET, mTicket);
                startActivityForResult(orderInt, 15);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10) {
            if (resultCode == 1){
                mCard = (Card)data.getSerializableExtra(CardActivity.CARD);
            }

        }
        if (requestCode == 15) {
            // Means they clicked purchase button
            if(resultCode == 1) {
                // RESET ALL THE VALUES BACK TO NOTHING
                Toast.makeText(getApplicationContext(), "Thank you for your purchase", Toast.LENGTH_LONG).show();

                // RESET SPINNER
                spinnerStartLoc.setSelection(0);
                spinnerEndLoc.setSelection(0);

                // RESET RADIO BUTTONS
                RadioButton temp = (RadioButton) findViewById(ticketTypeGroup.getCheckedRadioButtonId());
                if(temp != null)
                    // Reset
                    temp.setChecked(false);

                RadioButton tempAgain = (RadioButton) findViewById(priorityGroup.getCheckedRadioButtonId());
                if(tempAgain != null)
                    // Reset
                    tempAgain.setChecked(false);

                // RESET TICKET
                startLoc = "None";
                endLoc = "None";
                ticketType = "None";
                priority = "None";
                mCard = (Card)data.getSerializableExtra(CardActivity.CARD);
                mCard.setNumber("None");
                mCard.setName("None");
                // Increase the number of tickets purchased
                // Get ticket value from the current ticket Count text view
                numTickets = Integer.parseInt(ticketCountTextView.getText().toString());
                numTickets++;
                ticketCountTextView.setText(String.valueOf(numTickets));
            }
            // Means they clicked edit Ticket
            if(resultCode == 2) {

                Toast.makeText(getApplicationContext(), "Please make any necessary edits", Toast.LENGTH_LONG).show();
                mCard = (Card)data.getSerializableExtra(CardActivity.CARD);
            }
        }
    }





}
