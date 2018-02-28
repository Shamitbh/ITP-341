package itp341.a4_start;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    // bundle keys -> had to hard-code this b/c the static was messing things up
    public static final String KEY_DOGE = "itp341.bhatia.shamit.w3_d1.dog_count";
    public static final String KEY_SHOE = "itp341.bhatia.shamit.w3_d1.shoe_count";
    public static final String KEY_TREAT = "itp341.bhatia.shamit.w3_d1.treat_count";
    public static final String KEY_HUMAN = "itp341.bhatia.shamit.w3_d1.human_count";
    public static final String KEY_HYDRANT = "itp341.bhatia.shamit.w3_d1.hydrant_count";
    public static final String KEY_SHOE_COST = "itp341.bhatia.shamit.w3_d1.shoe_cost";
    public static final String KEY_TREAT_COST = "itp341.bhatia.shamit.w3_d1.treat_cost";
    public static final String KEY_HUMAN_COST = "itp341.bhatia.shamit.w3_d1.human_cost";
    public static final String KEY_HYDRANT_COST = "itp341.bhatia.shamit.w3_d1.hydrant_cost";



    private final double COST_MULTIPLIER = 1.2;
    private final double numShoeMultiplier = 0.5;
    private final double numTreatMultiplier = 1.5;
    private final double numHumanMultiplier = 10.0;
    private final double numHydrantMultiplier = 100.0;

    private TextView textViewDoge;
    private TextView textViewHydrant;
    private TextView textViewHuman;
    private TextView textViewShoe;
    private TextView textViewTreat;

    private ImageButton imageButtonMocha;

    private Button buttonHydrant;
    private Button buttonHuman;
    private Button buttonShoe;
    private Button buttonTreat;
    private Button buttonDetails;

    private long numDoge = 0;
    private long numHydrant = 0;
    private long numHuman = 0;
    private long numShoe = 0;
    private long numTreat = 0;

    private long numHydrantCost = 10000;
    private long numHumanCost = 1000;
    private long numShoeCost = 10;
    private long numTreatCost = 100;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putLong(KEY_DOGE, numDoge);
        outState.putLong(KEY_SHOE, numShoe);
        outState.putLong(KEY_TREAT, numTreat);
        outState.putLong(KEY_HUMAN, numHuman);
        outState.putLong(KEY_HYDRANT, numHydrant);

        outState.putLong(KEY_SHOE_COST, numShoeCost);
        outState.putLong(KEY_TREAT_COST, numTreatCost);
        outState.putLong(KEY_HUMAN_COST, numHumanCost);
        outState.putLong(KEY_HYDRANT_COST, numHydrantCost);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if savedInstanceState = null, then activity has never been created
        if (savedInstanceState != null) {
            numDoge = savedInstanceState.getLong(KEY_DOGE, 0);
            numShoe = savedInstanceState.getLong(KEY_SHOE, 0);
            numTreat = savedInstanceState.getLong(KEY_TREAT, 0);
            numHuman = savedInstanceState.getLong(KEY_HUMAN, 0);
            numHydrant = savedInstanceState.getLong(KEY_HYDRANT, 0);

            numShoeCost = savedInstanceState.getLong(KEY_SHOE_COST, 0);
            numTreatCost = savedInstanceState.getLong(KEY_TREAT_COST, 0);
            numHumanCost = savedInstanceState.getLong(KEY_HUMAN_COST, 0);
            numHydrantCost = savedInstanceState.getLong(KEY_HYDRANT_COST, 0);
        }

        Log.d(TAG, "onCreate Start");

        textViewDoge = (TextView) findViewById(R.id.textViewDogeCount);
        textViewHydrant = (TextView) findViewById(R.id.textViewHydrantCount);
        textViewHuman = (TextView) findViewById(R.id.textViewHumanCount);
        textViewShoe = (TextView) findViewById(R.id.textViewShoesCount);
        textViewTreat = (TextView) findViewById(R.id.textViewTreatsCount);

        Log.v(TAG, "Finished linking textviews");

        // Set textViews to correct values from previous instance
        // textViewDoge.setText(Long.toString(numDoge));
        textViewHydrant.setText(Long.toString(numHydrant));
        textViewHuman.setText(Long.toString(numHuman));
        textViewShoe.setText(Long.toString(numShoe));
        textViewTreat.setText(Long.toString(numTreat));


        imageButtonMocha = (ImageButton) findViewById(R.id.imageButtonMocha);
        imageButtonMocha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double addAmount = 1 + numShoe * numShoeMultiplier + numTreat * numTreatMultiplier
                        + numHuman * numHumanMultiplier + numHydrant * numHydrantMultiplier;

                Log.v(TAG, "Adding " + numShoe * numShoeMultiplier + " from shoes");
                Log.v(TAG, "Adding " + numTreat * numTreatMultiplier + " from treats");
                Log.v(TAG, "Adding " + numHuman * numHumanMultiplier + " from humans" );
                Log.v(TAG, "Adding " + numHydrant * numHydrantMultiplier + " from hydrants");

                Log.d(TAG, "Adding: " + addAmount + " to existing: " + numDoge);

                numDoge += addAmount;
                updateDogeCount();
                updateBuyButtons();
            }
        });

        DogeClickerButtonListener listener = new DogeClickerButtonListener();

        buttonHydrant = (Button) findViewById(R.id.buttonBuyHydrant);
        buttonHuman = (Button) findViewById(R.id.buttonBuyHuman);
        buttonShoe = (Button) findViewById(R.id.buttonBuyShoe);
        buttonTreat = (Button) findViewById(R.id.buttonBuyTreat);
        buttonDetails = (Button) findViewById(R.id.buttonDetails);

        Log.v(TAG, "Finished linking buttons");

        buttonHydrant.setOnClickListener(listener);
        buttonHuman.setOnClickListener(listener);
        buttonShoe.setOnClickListener(listener);
        buttonTreat.setOnClickListener(listener);
        buttonDetails.setOnClickListener(listener);

        Log.v(TAG, "Finished button listeners");

        String output = getResources().getString(R.string.textCost) + " ";

        buttonHydrant.setText(output + numHydrantCost);
        buttonHuman.setText(output + numHumanCost);
        buttonShoe.setText(output + numShoeCost);
        buttonTreat.setText(output + numTreatCost);

        updateBuyButtons();
        updateDogeCount();

        Log.d(TAG, "onCreate end");
    }

    private void updateDogeCount(){
        Log.v(TAG, "New numDoge: " + numDoge);
        textViewDoge.setText(numDoge + "");
    }

    private void updateBuyButtons(){
        Log.v(TAG, "buttonHydrant enabled: " + (numDoge >= numHydrantCost));
        buttonHydrant.setEnabled(numDoge >= numHydrantCost);
        Log.v(TAG, "buttonHuman enabled: " + (numDoge >= numHumanCost));
        buttonHuman.setEnabled(numDoge >= numHumanCost);
        Log.v(TAG, "buttonShoe enabled: " + (numDoge >= numShoeCost));
        buttonShoe.setEnabled(numDoge >= numShoeCost);
        Log.v(TAG, "buttonTreat enabled: " + (numDoge >= numTreatCost));
        buttonTreat.setEnabled(numDoge >= numTreatCost);
    }

    private class DogeClickerButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Log.d(TAG, "button clicked with id: " + v.getId());
            switch(v.getId()){
                case R.id.buttonBuyHuman:
                    Log.v(TAG, "Buying human for " + numHumanCost + " with " + numDoge + " in bank");
                    numDoge -= numHumanCost;
                    ++numHuman;
                    numHumanCost *= COST_MULTIPLIER;
                    Log.v(TAG, "Humans now cost " + numHumanCost);
                    ((Button) v).setText(getResources().getString(R.string.textCost) + " " + numHumanCost);
                    textViewHuman.setText(numHuman + "");
                    break;

                case R.id.buttonBuyHydrant:
                    Log.v(TAG, "Buying hydrant for " + numHydrantCost + " with " + numDoge + " in bank");
                    numDoge -= numHydrantCost;
                    ++numHydrant;
                    numHydrantCost *= COST_MULTIPLIER;
                    Log.v(TAG, "Hydrants now cost " + numHydrantCost);
                    ((Button) v).setText(getResources().getString(R.string.textCost) + " " + numHydrantCost);
                    textViewHydrant.setText(numHydrant + "");
                    break;

                case R.id.buttonBuyShoe:
                    Log.v(TAG, "Buying shoe for " + numShoeCost + " with " + numDoge + " in bank");
                    numDoge -= numShoeCost;
                    ++numShoe;
                    numShoeCost *= COST_MULTIPLIER;
                    Log.v(TAG, "Shoes now cost " + numShoeCost);
                    ((Button) v).setText(getResources().getString(R.string.textCost) + " " + numShoeCost);
                    textViewShoe.setText(numShoe + "");
                    break;

                case R.id.buttonBuyTreat:
                    Log.v(TAG, "Buying treat for " + numTreatCost + " with " + numDoge + " in bank");
                    numDoge -= numTreatCost;
                    ++numTreat;
                    numTreatCost *= COST_MULTIPLIER;
                    Log.v(TAG, "Treats now cost " + numTreatCost);
                    ((Button) v).setText(getResources().getString(R.string.textCost) + " " + numTreatCost);
                    textViewTreat.setText(numTreat + "");
                    break;
                case R.id.buttonDetails:
                    String labelMsg = getResources().getString(R.string.label_message);
                    // Get different strings
                    String treat = getResources().getString(R.string.treats);
                    String humans = getResources().getString(R.string.human);
                    String hydrant = getResources().getString(R.string.hydrants);
                    String shoes = getResources().getString(R.string.shoes);

                    String resultTreat = String.format(labelMsg,numTreat, treat, numTreat*numTreatMultiplier);
                    String resultHumans = String.format(labelMsg,numHuman, humans, numHuman*numTreatMultiplier);
                    String resultHydrant = String.format(labelMsg,numHydrant, hydrant, numHydrant*numHydrantMultiplier);
                    String resultShoes = String.format(labelMsg,numShoe, shoes, numShoe*numShoeMultiplier);

                    String resultTotal = resultShoes+"\n"+resultTreat+"\n"+resultHumans+"\n"+resultHydrant;

                    Toast.makeText(getApplicationContext(),resultTotal,Toast.LENGTH_LONG).show();
                default:
                    break;
            }

            updateBuyButtons();
            updateDogeCount();
        }
    }
}
