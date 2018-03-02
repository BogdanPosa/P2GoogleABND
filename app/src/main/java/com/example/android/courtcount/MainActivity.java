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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    /**
     * Increase the score for Team A by 1 point.
     */


    public void addOneForTeamA(View v) {
        EditText textScore = findViewById(R.id.TAthrow1);
        String value = textScore.getText().toString();
        int finalValue = Integer.parseInt(value);
        if (finalValue < 101) {
            scoreTeamA = scoreTeamA + finalValue;
            displayForTeamA(scoreTeamA);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "The score you entered is too big!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        EditText textScore = findViewById(R.id.TAthrow1);
        String value = textScore.getText().toString();
        int finalValue = Integer.parseInt(value);
        if (finalValue < 101) {
            scoreTeamA = scoreTeamA + 2 * finalValue;
            displayForTeamA(scoreTeamA);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "The score you entered is too big!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        EditText textScore = findViewById(R.id.TAthrow1);
        String value = textScore.getText().toString();
        int finalValue = Integer.parseInt(value);
        if (finalValue < 101) {
            scoreTeamA = scoreTeamA + 3 * finalValue;
            displayForTeamA(scoreTeamA);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "The score you entered is too big!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
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
        EditText textScore = findViewById(R.id.TBthrow1);
        String value = textScore.getText().toString();
        int finalValue = Integer.parseInt(value);
        if (finalValue < 101) {
            scoreTeamB = scoreTeamB + finalValue;
            displayForTeamB(scoreTeamB);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "The score you entered is too big!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        EditText textScore = findViewById(R.id.TBthrow1);
        String value = textScore.getText().toString();
        int finalValue = Integer.parseInt(value);
        if (finalValue < 101) {
            scoreTeamB = scoreTeamB + 2 * finalValue;
            displayForTeamB(scoreTeamB);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "The score you entered is too big!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        EditText textScore = findViewById(R.id.TBthrow1);
        String value = textScore.getText().toString();
        int finalValue = Integer.parseInt(value);
        if (finalValue < 101) {
            scoreTeamB = scoreTeamB + 3 * finalValue;
            displayForTeamB(scoreTeamB);
        } else {
            Context context = getApplicationContext();
            CharSequence text = "The score you entered is too big!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
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
     * This method makes the keyboard disappear when clicking outside
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