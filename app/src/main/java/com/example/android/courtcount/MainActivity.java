package com.example.android.courtcount;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int finalValue;
    boolean scorOK;
    EditText textScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   textScore = findViewById(R.id.TAthrow1);
    }


    /**x
     * This method takes the user input
     */

    public void getScore() {
        String value = textScore.getText().toString();
        if (!value.isEmpty()) {
            finalValue = Integer.parseInt(value);
        } else {
            Context context = getApplicationContext();
            Toast.makeText(context, "Please enter a numeric value!", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method checks that the user input is ok
     */


    public void checkScore() {
        if (finalValue < 101) {
            scorOK = true;
        } else {
            scorOK = false;
            Context context = getApplicationContext();
            CharSequence text = "The score you entered is too big!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    /**
     * Increase the score for Team A by 1 point.
     */

    public void addOneForTeamA(View v) {
        getScore();
        checkScore();
        if (scorOK) {
            scoreTeamA = scoreTeamA + finalValue;
            displayForTeamA(scoreTeamA);
        }
        textScore.setText("");
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        getScore();
        checkScore();
        if (scorOK) {
            scoreTeamA = scoreTeamA + 2 * finalValue;
            displayForTeamA(scoreTeamA);
        }
        textScore.setText("");

    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        getScore();
        checkScore();
        if (scorOK) {
            scoreTeamA = scoreTeamA + 3 * finalValue;
            displayForTeamA(scoreTeamA);
        }
        textScore.setText("");

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        getScore();
        checkScore();
        if (scorOK) {
            scoreTeamB = scoreTeamB + finalValue;
            displayForTeamB(scoreTeamB);
        }
        textScore.setText("");
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        getScore();
        checkScore();
        if (scorOK) {
            scoreTeamB = scoreTeamB + 2 * finalValue;
            displayForTeamB(scoreTeamB);
        }
        textScore.setText("");
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        getScore();
        checkScore();
        if (scorOK) {
            scoreTeamB = scoreTeamB + 3 * finalValue;
            displayForTeamB(scoreTeamB);
        }
        textScore.setText("");
    }

    /**
     * Reset the score for Team
     */
    public void reset(View v) {
        scoreTeamA = 0;
        displayForTeamA(scoreTeamA);
        scoreTeamB = 0;
        displayForTeamB(scoreTeamB);
    }

    /**
     * This method compares the score of the teams
     */

    public void compare(View v) {
        if (scoreTeamA > scoreTeamB) {
            Context context = getApplicationContext();
            CharSequence text = "Player A won!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            if (scoreTeamB > scoreTeamA) {
                Context context = getApplicationContext();
                CharSequence text = "player B won!";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            } else {
                if (scoreTeamB == scoreTeamA) {
                    Context context = getApplicationContext();
                    CharSequence text = "Tie!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        }
    }

    /**
     * This method makes the keyboard disappear when losing focus
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    /**
     * Reset the score for Team
     */
    public void showHint(View v) {
        Context context = getApplicationContext();
        CharSequence text = "Simple game of darts, each player throws 3 darts each round. The player who makes more points wins!";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}