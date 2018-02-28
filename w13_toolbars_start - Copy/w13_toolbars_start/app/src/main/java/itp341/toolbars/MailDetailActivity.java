package itp341.toolbars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    // TODO: Add a "delete" and a "mark as unread" item to the menu.
    // TODO: Implement onCreateOptionsMenu by inflating the menu.

    // TODO: Implement onOptionsItemSelected and switch on the item's id to take action.

}
