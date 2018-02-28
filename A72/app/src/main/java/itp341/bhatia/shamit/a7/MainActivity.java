package itp341.bhatia.shamit.a7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

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

        spinnerStartLoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s = adapterView.getItemAtPosition(i).toString();
                ticketCountTextView.setText(s);
            }
        });

    }
}
//        btnUseCard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(MainActivity.this, CardActivity.class);
//                startActivityForResult(i, 0);
//            }
//        });
//
//        btnVerify.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//
//    }
//
////    @Override
////    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
////        super.onActivityResult(requestCode, resultCode, data);
////        if (requestCode == 0){
////            Card myCard;
////            myCard = (Card)getIntent().getSerializableExtra(CardActivity.EXTRA_CARD_MAIN);
////        }
////    }
//
//}
