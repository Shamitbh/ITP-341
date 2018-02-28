package itp341.geoquiz.Model;

import java.io.Serializable;

/**
 * Created by Shamit on 9/25/17.
 */

public class QuizQuestion implements Serializable{
    private String question;
    private boolean answer;

    public QuizQuestion(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    public QuizQuestion(String question, int booleanAsInt) {
        this.question = question;
        if (booleanAsInt == 0){
            this.answer = false;
        }
        else{
            this.answer = true;
        }
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "QuizQuestion{" +
                "question='" + question + '\'' +
                ", answer=" + answer +
                '}';
    }
}
