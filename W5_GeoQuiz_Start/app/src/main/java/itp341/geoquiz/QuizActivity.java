package itp341.geoquiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/*
 *	Functionality:
 *		True / False buttons
 *			Displays message based on cheating status and correct answer
 *
 *		Next button
 *			loads next question 
 *
 *		Cheat button
 *			launches CheatActivity
 *
 * 	Saving state:
 *		If the activity is re-created, the current state should be restored
 *		Implement this behavior  (hint: what data needs to be saved?)
 *
 *		
 */
public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
    public static final String EXTRA_USER_CHEATED = "itp341.geoquiz.extra_user_cheated";


    //View references
    Button buttonTrue;
    Button buttonFalse;
    Button buttonNext;
    Button buttonCheat;
    TextView textQuestion;
    
    //Instance variables
    boolean isCheater;		//flag which indicates if user cheated on current question
    String[] questions;		//array of questions
    int[] answers;			//array of answers (0 for false, 1 for true)
    int currentIndex;		//current question

    //TODO
    /*
     * onCreate - method is not complete
     */
    @Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    Log.d(TAG, "onCreate() called");
	    setContentView(R.layout.activity_quiz);
	    
	
	  
	    //find view
	    textQuestion = (TextView)findViewById(R.id.text_question);
	    buttonTrue = (Button)findViewById(R.id.button_true);	
	    buttonFalse = (Button)findViewById(R.id.button_false);
	    buttonNext = (Button)findViewById(R.id.button_next);
	    buttonCheat = (Button)findViewById(R.id.button_cheat);
	    
	    //initialize variables
        currentIndex = 0;   // SHOULD FIX LATER FOR ROTATING SCREEN (ONSAVEDINSTANCE)
	    isCheater = false;		//assume user has NOT cheated
	    questions = getResources().getStringArray(R.array.array_questions);
	    answers = getResources().getIntArray(R.array.array_answers);
	    
	    //set up listeners
	    buttonTrue.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	            checkAnswer(true);			//pass true because this is the True button
	        }
	    });
	
	    		
	    buttonFalse.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	            checkAnswer(false);			//pass false because this is the False button
	        }
	    });
	
	    //TODO
	    /*
	     * setup buttonNext event handler
	     * 	
	     */
	    buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex + 1) % questions.length;
                updateQuestion();
                isCheater = false;
            }
        });
	    
	    //TODO
	    /*
	     * setup buttonCheat event handler
	     */
	    buttonCheat.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
                // Launching new activity
                // 1) Build intent
                Intent i = new Intent(getApplicationContext(), CheatActivity.class);

                boolean answer = (answers[currentIndex] == 1);
                // Load intent with extra data
                i.putExtra(CheatActivity.EXTRA_ANSWER, answer);
                // Use startActivityForResult because need to remember whether user cheats or not
                startActivityForResult(i, 0);


			}
		});

	
  
	
	    updateQuestion();
	}
    
    //TODO 
    /*
     * 	updateQuestion
     * 		Uses the current index to update the text view with the current question
     */
	private void updateQuestion() {
        textQuestion.setText(questions[currentIndex]);
    }
	
	//TODO 
    /*
     * 	checkAnswer
     * 		input: boolean - indicates if user pressed true or false
     * 		side-effect: displays a Toast based on 1) user's answer and 2) whether they cheated or not
     * 
     * 		scenarios --> Toast message
     * 			User didn't cheat and answered incorrectly 	--> incorrect
     * 			User didn't cheat and answered correctly 	--> correct
     * 			User did cheat and answered incorrectly 	--> incorrect_judgment
     * 			User did cheat and answered correctly 		--> correct_judgment
     */
	private void checkAnswer(boolean userPressedTrue) {

		boolean answer = (answers[currentIndex] == 1);

        // use this to keep track of which ID to print in toast later
        int messageResId = 0;

        // if user cheated
        if (isCheater) {
            // user cheated AND answer correctly
            if (userPressedTrue == answer) {
                messageResId = R.string.toast_correct_judgment;
            }
            // user cheated AND answers incorrectly
            else{
                messageResId = R.string.toast_incorrect_judgment;
            }
        }
        else{ // user didnt cheat
            if (userPressedTrue == answer) {
                messageResId = R.string.toast_correct;
            }
            // user cheated AND answers incorrectly
            else{
                messageResId = R.string.toast_incorrect;
            }
        }

        Toast.makeText(getApplicationContext(), messageResId, Toast.LENGTH_SHORT).show();

        // Send answer to the next activity using putExtra

    }
    
    //TODO 
    /*
     * 	onActivityResult
     * 		check if user cheated and update isCheater
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	Log.d(TAG, "onActivityResult");
        isCheater = data.getBooleanExtra(EXTRA_USER_CHEATED, false);
    }

    //TODO 
    /*
     * 	onSaveInstanceState
     * 		
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.d(TAG, "onSaveInstanceState");
        
    }
    

}
