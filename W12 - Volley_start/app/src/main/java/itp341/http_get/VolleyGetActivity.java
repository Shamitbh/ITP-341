package itp341.http_get;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class VolleyGetActivity extends AppCompatActivity {
    private final String TAG = VolleyGetActivity.class.getName();

    //TODO URL string
    private final String URL = "https://restcountries.eu/rest/v2/name/";


    private Button buttonSend;
    private EditText editCountryName;
    private TextView textJSON;
    private TextView textActivityTitle;
    private TextView textPopulation;
    private ListView listLanguages;
    private RelativeLayout layout;

    ArrayAdapter<String> adapter;
    ArrayList<String> languages;

    //TODO Volley
    private RequestQueue queue; //for volley to store / batch process all network requests


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        layout = (RelativeLayout) findViewById(R.id.layout);
        buttonSend = (Button) findViewById(R.id.button_send);
        editCountryName = (EditText) findViewById(R.id.edit_country_name);
        textJSON = (TextView) findViewById(R.id.text_json);
        textPopulation = (TextView) findViewById(R.id.text_population);;
        textActivityTitle = (TextView) findViewById(R.id.text_activity_title);
        listLanguages = (ListView) findViewById(R.id.list_languages);

        layout.setBackgroundColor(Color.parseColor("#d6fffc"));

        //read intent for activity label
        Intent i = getIntent();
        String title = i.getStringExtra(MainActivity.EXTRA_ACTIVITY_TITLE);
        textActivityTitle.setText(title);


        languages = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                languages);
        listLanguages.setAdapter(adapter);

        //TODO set up Volley queue
        queue = Volley.newRequestQueue(this);


        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country = editCountryName.getText().toString();
                String requestUrl = URL + country;

                requestJSONParse(requestUrl);
            }
        });
    }

    //TODO This will contact the Volley request for String data
    public void requestString(String reqURL) {

    }

    //TODO This will contact the Volley request for JSON data
    public void requestJSONParse(String reqURL) {
        JsonArrayRequest request = new JsonArrayRequest(reqURL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) { //this response variable is the json object
                try {
                    JSONObject country = (JSONObject) response.get(0);
                    String population = country.getString("population");


                    textPopulation.setText(population);
                    textJSON.setText(response.toString());

                    //clear the list
                    languages.clear();
                    JSONArray languagesJSON = country.getJSONArray("languages");
                    for(int i = 0; i < languagesJSON.length(); i++) {
                        JSONObject obj = (JSONObject) languagesJSON.get(i);
                        String languageName = obj.getString("name");
                        languages.add(languageName);
                    }
                    adapter.notifyDataSetChanged();
                }
                catch(JSONException je){
                    je.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        queue.add(request);
    }

}
