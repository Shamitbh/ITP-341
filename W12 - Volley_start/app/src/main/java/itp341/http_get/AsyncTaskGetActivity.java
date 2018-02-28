package itp341.http_get;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AsyncTaskGetActivity extends AppCompatActivity {
    private final String TAG = AsyncTaskGetActivity.class.getName();
    //TODO URL string
    private final String URL = "";


    private Button buttonSend;
    private EditText editCountryName;
    private TextView textJSON;
    private TextView textActivityTitle;
    private TextView textPopulation;
    private ListView listLanguages;
    private RelativeLayout layout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        layout = (RelativeLayout) findViewById(R.id.layout);

        buttonSend = (Button) findViewById(R.id.button_send);
        editCountryName = (EditText) findViewById(R.id.edit_country_name);
        textJSON = (TextView) findViewById(R.id.text_json);
        textPopulation = (TextView) findViewById(R.id.text_population);;
        textActivityTitle = (TextView) findViewById(R.id.text_activity_title);;
        listLanguages = (ListView) findViewById(R.id.list_languages);;

        layout.setBackgroundColor(Color.parseColor("#fffbd6"));


        //read intent for activity label
        Intent i = getIntent();
        String title = i.getStringExtra(MainActivity.EXTRA_ACTIVITY_TITLE);
        textActivityTitle.setText(title);



        //TODO execute volley request
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    //TODO build volley request
    public void requestJSONParse(String reqURL) {

    }



}
