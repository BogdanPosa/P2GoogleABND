package com.example.android.courtcount;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    int scorePlayer1 = 0;
    int scorePlayer2 = 0;
    int finalValuePlayer1, finalValuePlayer2;
//    ToggleButton toggle;
    EditText Player1Name, Player2Name;
    Spinner spinnerPlayer1, spinnerPlayer2;
    List<String> lstSource = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        toggle = findViewById(R.id.toggleHelp);
        Player1Name = findViewById(R.id.Player1);
        Player2Name = findViewById(R.id.Player2);

        generateData();

        spinnerPlayer1 = findViewById(R.id.spinnerPlayer1);
        SpinnerAdapter adapter = new SpinnerAdapter(lstSource, MainActivity.this);
        spinnerPlayer1.setAdapter(adapter);

        spinnerPlayer2 = findViewById(R.id.spinnerPlayer2);
        SpinnerAdapter adapter2 = new SpinnerAdapter(lstSource, MainActivity.this);
        spinnerPlayer2.setAdapter(adapter2);

    }

    private void generateData() {
        for (int i = 0; i < 23; i++) {
            lstSource.add("Item " + i);
        }
    }

    /**
     * x
     * This method takes the user input
     */

    public void getScore() {
        finalValuePlayer1 = spinnerPlayer1.getSelectedItemPosition();
        finalValuePlayer2 = spinnerPlayer2.getSelectedItemPosition();
    }

    /**
     * Increase the score for Team A by 1x point.
     */

    public void addOneForTeamA(View v) {
        getScore();
        if (finalValuePlayer1 < 21) {
            scorePlayer1 = scorePlayer1 + finalValuePlayer1;
        } else {
            if (finalValuePlayer1 == 21) {
                scorePlayer1 = scorePlayer1 + 25;
            } else {
                if (finalValuePlayer1 == 22) {
                    scorePlayer1 = scorePlayer1 + 50;
                }
            }
        }
        displayForTeamA(scorePlayer1);

        spinnerPlayer1.setSelection(0);
    }

    /**
     * Increase the score for Team A by 2x points.
     */
    public void addTwoForTeamA(View v) {
        getScore();
        if (finalValuePlayer1 == 0 || finalValuePlayer1 == 21 || finalValuePlayer1 == 22) {
            Context context = getApplicationContext();
            CharSequence text = "Can't have a double of Bullseye or Fault";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            if (finalValuePlayer1 < 21) {
                scorePlayer1 = scorePlayer1 + 2 * finalValuePlayer1;
            }
        }
        displayForTeamA(scorePlayer1);
        spinnerPlayer1.setSelection(0);
    }

    /**
     * Increase the score for Team A by 3x points.
     */
    public void addThreeForTeamA(View v) {
        getScore();
        if (finalValuePlayer1 == 0 || finalValuePlayer1 == 21 || finalValuePlayer1 == 22) {
            Context context = getApplicationContext();
            CharSequence text = "Can't have a triple of Bullseye or Fault";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            if (finalValuePlayer1 < 21) {
                scorePlayer1 = scorePlayer1 + 3 * finalValuePlayer1;
            }
        }
        displayForTeamA(scorePlayer1);
        spinnerPlayer1.setSelection(0);
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
     * Increase the score for Team A by 1x point.
     */

    public void addOneForTeamB(View v) {
        getScore();
        if (finalValuePlayer2 < 21) {
            scorePlayer2 = scorePlayer2 + finalValuePlayer2;
        } else {
            if (finalValuePlayer2 == 21) {
                scorePlayer2 = scorePlayer2 + 25;
            } else {
                if (finalValuePlayer2 == 22) {
                    scorePlayer2 = scorePlayer2 + 50;
                }
            }
        }
        displayForTeamB(scorePlayer2);

        spinnerPlayer2.setSelection(0);
    }

    /**
     * Increase the score for Team B by 2x points.
     */
    public void addTwoForTeamB(View v) {
        getScore();
        if (finalValuePlayer2 == 0 || finalValuePlayer2 == 21 || finalValuePlayer2 == 22) {
            Context context = getApplicationContext();
            CharSequence text = "Can't have a double of Bullseye or Fault";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            if (finalValuePlayer2 < 21) {
                scorePlayer2 = scorePlayer2 + 2 * finalValuePlayer2;
            }
        }
        displayForTeamB(scorePlayer2);
        spinnerPlayer2.setSelection(0);
    }

    /**
     * Increase the score for Team B by 3x points.
     */
    public void addThreeForTeamB(View v) {
        getScore();
        if (finalValuePlayer2 == 0 || finalValuePlayer2 == 21 || finalValuePlayer2 == 22) {
            Context context = getApplicationContext();
            CharSequence text = "Can't have a triple of Bullseye or Fault";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            if (finalValuePlayer2 < 21) {
                scorePlayer2 = scorePlayer2 + 3 * finalValuePlayer2;
            }
        }
        displayForTeamB(scorePlayer2);
        spinnerPlayer2.setSelection(0);
    }

    /**
     * Reset the score for Team
     */
    public void reset(View v) {
        scorePlayer1 = 0;
        displayForTeamA(scorePlayer1);
        scorePlayer2 = 0;
        displayForTeamB(scorePlayer2);
        Player1Name.setText("");
        Player2Name.setText("");
        spinnerPlayer1.setSelection(0);
    }

    /**
     * This method compares the score of the teams
     */

    public void compare(View v) {
        String namePlayer1 = Player1Name.getText().toString();
        String namePlayer2 = Player2Name.getText().toString();
        if (!namePlayer1.isEmpty() && !namePlayer2.isEmpty()) {

            if (scorePlayer2 > scorePlayer1) {
                Context context = getApplicationContext();
                CharSequence text = namePlayer2 + " won!";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            } else {
                if (scorePlayer1 > scorePlayer2) {
                    Context context = getApplicationContext();
                    CharSequence text = namePlayer1 + " won!";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    if (scorePlayer1 == scorePlayer2) {
                        Context context = getApplicationContext();
                        CharSequence text = "Tie!";
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
            }
        } else {
            if (namePlayer1.isEmpty()) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Please enter a name for player 1!", Toast.LENGTH_SHORT).show();
            } else {
                if (namePlayer2.isEmpty()) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Please enter a name for player 2!", Toast.LENGTH_SHORT).show();
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
     * Show hint
     */
    public void showHint(View v) {
        Context context = getApplicationContext();
        CharSequence text = "Simple game of darts, each player throws 3 darts each round. The player who makes more points wins!";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


//            toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//            if (isChecked) {
//                Context context = getApplicationContext();
//                CharSequence text = "Simple game of darts, each player throws 3 darts each round. The player who makes more points wins!";
//                int duration = Toast.LENGTH_LONG;
//                Toast toast = Toast.makeText(context, text, duration);
//                toast.show();
//            } else {
//                Context context = getApplicationContext();
//                CharSequence text = "Click the off button for help";
//                int duration = Toast.LENGTH_LONG;
//                Toast toast = Toast.makeText(context, text, duration);
//                toast.show();
//            }
//        }
//    });
}