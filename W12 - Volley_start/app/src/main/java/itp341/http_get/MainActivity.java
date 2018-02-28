package itp341.http_get;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getName();
    public final static String EXTRA_ACTIVITY_TITLE = "activity_title";


    private Button buttonAsyncTask;
    private Button buttonVolley;
    private Button buttonRetrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAsyncTask = (Button) findViewById(R.id.button_async_task);
        buttonVolley = (Button) findViewById(R.id.button_volley);
        buttonRetrofit = (Button) findViewById(R.id.button_retrofit);

        buttonAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "on click", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), AsyncTaskGetActivity.class);
                i.putExtra(EXTRA_ACTIVITY_TITLE, "AsyncTask Example;");
                startActivity(i);
            }
        });
        buttonVolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), VolleyGetActivity.class);
                i.putExtra(EXTRA_ACTIVITY_TITLE, "Volley Example;");
                startActivity(i);
            }
        });
        buttonRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RetrofitGetActivity.class);
                i.putExtra(EXTRA_ACTIVITY_TITLE, "Volley Example;");
                startActivity(i);
            }
        });
    }


}
