package itp341.bhatia.shamit.a7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

import itp341.bhatia.shamit.a7.Model.Card;


/**
 * Created by Shamit on 10/17/17.
 */

public class CardActivity extends AppCompatActivity{

    // Tagging variables
    public static final String CARD = "itp341.CARD";

    // Private instance variables
    private String userCardNum;
    private String userCardName;
    Intent i;

    // References to widgets
    private EditText cardNumEdit;
    private EditText cardNameEdit;
    private Button btnSaveCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        cardNumEdit = (EditText) findViewById(R.id.cardNumUserEntry);
        cardNameEdit = (EditText) findViewById(R.id.cardNameUserEntry);
        btnSaveCard = (Button) findViewById(R.id.saveCard);

        i = getIntent();

        btnSaveCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCardNum = cardNumEdit.getText().toString();
                userCardName = cardNameEdit.getText().toString();
                // Create dummy intent
                Intent dummyIntent = new Intent();
                // Get intent from main and put into new Card Objects
                Card tempCard = (Card) i.getSerializableExtra(CARD);

                // Set name and number for new tempCard
                tempCard.setNumber(userCardNum);
                tempCard.setName(userCardName);

                // Put the new temp card onto dummy intent to send back to parent
                dummyIntent.putExtra(CARD, tempCard);
                setResult(1, dummyIntent);
                finish();
            }
        });

    }
}