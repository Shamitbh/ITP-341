package itp341.http_get;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LanguagesActivity extends AppCompatActivity {
    public final static String EXTRA_LANGUAGE = "extra_language";
    private final static String TAG = LanguagesActivity.class.getSimpleName();

    private final String URL = "";


    private ListView listCountries;
    private TextView textLanguage;
    private RelativeLayout layout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);
        layout = (RelativeLayout) findViewById(R.id.layout);

        textLanguage = (TextView) findViewById(R.id.text_language);
        listCountries = (ListView) findViewById(R.id.list_countries);
        layout.setBackgroundColor(Color.parseColor("#d6fffc"));








    }

    public void requestJSONParse(String reqURL) {

    }
}
