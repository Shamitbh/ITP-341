package itp341.toolbars;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import itp341.toolbars.Model.Mail;
import itp341.toolbars.R;


public class MainActivity extends AppCompatActivity {

    private static final int DETAIL_ACTIVITY_REQUEST_CODE = 100;

    private ListView mListView;

    // TODO: Create a reference to Toolbar.
    private Toolbar mToolBar;

    private MailAdapter mMailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMailAdapter = new MailAdapter(getApplicationContext(), R.layout.layout_item_mail, Mail
                .MailSingleton.getInstance().getAllMail());

        mListView = (ListView) findViewById(R.id.main_list);
        mListView.setAdapter(mMailAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), MailDetailActivity.class);
                i.putExtra(MailDetailActivity.INDEX, position);
                startActivityForResult(i, DETAIL_ACTIVITY_REQUEST_CODE);
            }
        });

        // TODO: Find Toolbar from View and set as ActionBar.
        mToolBar = (Toolbar)findViewById(R.id.main_toolbar);

        setSupportActionBar(mToolBar);
        ActionBar actionBar = getSupportActionBar();

        // TODO: Get Support ActionBar and if not null, set the title.
        if (actionBar != null){
            actionBar.setTitle("ITP 341 Mail App");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mMailAdapter.notifyDataSetChanged();
    }

}
