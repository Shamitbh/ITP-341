package itp341.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
 *	Functionality:
 *		Show Answer Button
 *			Displays answer to question (either true or false) using String resource
 *			Sets intent boolean extra value to false
 *
 *		Back Button
 *			User will terminate CheatActivity by pressing the back button
 *			
 *	Sending Intent Result back to Quiz Activity:
 * 		Instead of using Result_OK or Result_CANCELED, we will create an Intent 
 * 		and pass an boolean Extra that will indicate if the user cheated or not
 * 
 * 	Second Thoughts:
 * 		If the user loads this activity but decides not to click Show Answer, 
 * 		then that is NOT considered cheating so the boolean extra should indicate false
 * 
 */

public class CheatActivity extends AppCompatActivity {

	private static final String TAG = "CheatActivity";
    // add Key here
    public static final String EXTRA_ANSWER = "itp341.geoquiz.extra_answer";
	
	// View references
	TextView textAnswer;
	Button buttonShowAnswer;

	// instance variables
	boolean answer;

	//TODO
	/*
	 * onCreate - method is not complete (besides adding button listener)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate() called");
		setContentView(R.layout.activity_cheat);
		Log.d(TAG, getCallingActivity().toString());

		//find views
		textAnswer = (TextView) findViewById(R.id.text_answer);
		buttonShowAnswer = (Button) findViewById(R.id.button_show_answer);

		answer = getIntent().getBooleanExtra(EXTRA_ANSWER,false);
		

	    //TODO
	    /*
	     * 	setup buttonShowAnswer event handler
	     * 		- displays the correct answer
	     * 		- sets result value to indicate cheating
	     */
	    buttonShowAnswer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

                // call setResult which will tell parent that the user cheated
                Intent data = new Intent(); // this intent is EMPTY because it is a "dummy" intent, it wont be launched so no getAppcontext, etc.

                data.putExtra(QuizActivity.EXTRA_USER_CHEATED, true);
                setResult(Activity.RESULT_OK, data);

				if (answer) {
                    textAnswer.setText(R.string.label_true);
                }
                else {
                    textAnswer.setText(R.string.label_false);
                }
			}
		});
		
	}
	

}
