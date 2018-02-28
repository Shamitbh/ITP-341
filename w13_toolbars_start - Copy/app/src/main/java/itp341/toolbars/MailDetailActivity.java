package itp341.toolbars;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import itp341.toolbars.Model.Mail;
import itp341.toolbars.R;


public class MailDetailActivity extends AppCompatActivity {
    public static final String INDEX = "com.itp341.usc.demotoolbars.View.MailDetailActivity.INDEX";



    // TODO: Create reference to Toolbar.

    private TextView mTextViewSender;
    private TextView mTextViewTitle;
    private TextView mTextViewMessage;

    private Mail mMail;
    private int mIndex;

    private Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_detail);

        Intent i = getIntent();
        mIndex = i.getIntExtra(INDEX, -1);

        mMail = Mail.MailSingleton.getInstance().getMail(mIndex);

        if (mMail == null)
        {
            finish();
        }

        // TODO: Find Toolbar in view and set as support ActionBar.
        mToolBar = (Toolbar)findViewById(R.id.main_toolbar);

        setSupportActionBar(mToolBar);
        ActionBar actionBar = getSupportActionBar();

        // TODO: Get Support ActionBar and if not null, set the title.
        if (actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
        }
        // TODO: Get SupportActionBar. If not null, do the following:
        // TODO: Enable Home Button.
        // TODO: Enable Home as up.
        // TODO: Disable Title.
        // TODO: Add the following to the activity in mainifest:
        // TODO: android:parentActivityName=".View.MainActivity"

        mTextViewTitle = (TextView) findViewById(R.id.detail_title);
        mTextViewSender = (TextView) findViewById(R.id.detail_sender);
        mTextViewMessage = (TextView) findViewById(R.id.detail_message);

        mTextViewTitle.setText(mMail.getTitle());
        mTextViewSender.setText(mMail.getSender());
        mTextViewMessage.setText(mMail.getMessage());
        Mail.MailSingleton.getInstance().markReadStatus(mIndex, true);
    }

    // TODO: Create a menu folder and a menu resource in that folder.

    // this method loads a file and shows it on screen
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // code for this is typically always the same
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // this method is overall listener for EVERY menu item on current screen
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.menu_detail_delete:
                Mail.MailSingleton.getInstance().deleteMail(mIndex);
                finish();
                break;
            case R.id.menu_detail_unread:
                Mail.MailSingleton.getInstance().markReadStatus(mIndex, false);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    // TODO: Add a "delete" and a "mark as unread" item to the menu.
    // TODO: Implement onCreateOptionsMenu by inflating the menu.

    // TODO: Implement onOptionsItemSelected and switch on the item's id to take action.

}
