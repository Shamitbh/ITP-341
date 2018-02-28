package itp341.http_get;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RetrofitGetActivity extends AppCompatActivity {
    private final String TAG = RetrofitGetActivity.class.getName();
    private final String URL = "https://restcountries.eu/rest/v2/name/";

    private Button buttonSend;
    private EditText editCountryName;
    private TextView textJSON;
    private TextView textActivityTitle;
    private TextView textPopulation;
    private ListView listLanguages;

    ArrayAdapter<String> adapter;
    ArrayList<String> languages;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        buttonSend = (Button) findViewById(R.id.button_send);
        editCountryName = (EditText) findViewById(R.id.edit_country_name);
        textJSON = (TextView) findViewById(R.id.text_json);
        textPopulation = (TextView) findViewById(R.id.text_population);;
        textActivityTitle = (TextView) findViewById(R.id.text_activity_title);;
        listLanguages = (ListView) findViewById(R.id.list_languages);;

        //read intent for activity label
        Intent i = getIntent();
        String title = i.getStringExtra(MainActivity.EXTRA_ACTIVITY_TITLE);
        textActivityTitle.setText(title);




        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }



}
