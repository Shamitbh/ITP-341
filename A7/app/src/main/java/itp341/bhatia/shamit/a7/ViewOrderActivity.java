package itp341.bhatia.shamit.a7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import itp341.bhatia.shamit.a7.Model.Card;
import itp341.bhatia.shamit.a7.Model.Ticket;

/**
 * Created by Shamit on 10/17/17.
 */

public class ViewOrderActivity extends AppCompatActivity {

    // Tagging variables
    public static final String TICKET = "itp341.TICKET";
    Intent i;
    Card ca;
    Ticket tick;

    // References to widgets
    private TextView tripFromText;
    private TextView tripToText;
    private TextView ticketText;
    private TextView priorityText;
    private TextView cardNumText;
    private TextView cardNameText;
    private Button editTktBtn;
    private Button editCardBtn;
    private Button purchaseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_orders);

        tripFromText = (TextView) findViewById(R.id.tripFromValue);
        tripToText = (TextView) findViewById(R.id.tripToValue);
        ticketText = (TextView) findViewById(R.id.tripTypeValue);
        priorityText = (TextView) findViewById(R.id.tripPriorityValue);
        cardNumText = (TextView) findViewById(R.id.cardNumValue);
        cardNameText = (TextView) findViewById(R.id.cardNameValue);
        editTktBtn = (Button) findViewById(R.id.editTicket);
        editCardBtn = (Button) findViewById(R.id.editCard);
        purchaseBtn = (Button) findViewById(R.id.purchase);

        i = getIntent();
        ca = (Card) i.getSerializableExtra(CardActivity.CARD);
        tick = (Ticket)i.getSerializableExtra(TICKET);

        // Set all the widgets to correct card/ticket values, but check if not null first
        if (ca != null) {
            cardNumText.setText(ca.getNumber());
            cardNameText.setText(ca.getName());
        }
        if (tick != null){
            tripFromText.setText(tick.getStartingLocation());
            tripToText.setText(tick.getEndingLocation());
            ticketText.setText(tick.getTripType());
            priorityText.setText(tick.getPriorities());
        }

        // Add listeners here
        editTktBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Return the most up to date card back to main activity
                Intent dummyInt = new Intent();
                dummyInt.putExtra(CardActivity.CARD, ca);
                setResult(2, dummyInt);
                finish();
            }
        });

        editCardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Card displayed needs to be changed - launch card activity
                Intent cardInt = new Intent(ViewOrderActivity.this, CardActivity.class);
                cardInt.putExtra(CardActivity.CARD, ca);
                // Start activity for result with a request code
                startActivityForResult(cardInt, 5);
            }
        });

        purchaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dummyInt = new Intent();
                dummyInt.putExtra(CardActivity.CARD, ca);
                setResult(1, dummyInt);
                finish();
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5 && resultCode == 1){
            // Card has been updated successfully
            ca = (Card)data.getSerializableExtra(CardActivity.CARD);
            // Set the Textview widgets to correct numbers
            cardNumText.setText(ca.getNumber());
            cardNameText.setText(ca.getName());
        }
    }

}
