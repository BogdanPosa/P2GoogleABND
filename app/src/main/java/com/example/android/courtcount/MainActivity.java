package com.example.android.courtcount;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int scorePlayer1 = 0;
    int scorePlayer2 = 0;
    int remainingShotsPlayer1;
    int remainingShotsPlayer2;
    int finalValuePlayer1;
    int finalValuePlayer2;
    boolean player1Throw;
    boolean player2Throw;
    ToggleButton toggle;
    EditText player1Name;
    EditText player2Name;
    EditText maximShots;
    TextView p1Remaining;
    TextView p2Remaining;
    Spinner spinnerPlayer1;
    Spinner spinnerPlayer2;
    List<String> lstSource = new ArrayList<>();
    LinearLayout linearLayout1;
    LinearLayout linearLayout2;
    String maxShotsValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggle = findViewById(R.id.toggleHelp);
        toggle.setChecked(false);
        player1Name = findViewById(R.id.Player1);
        player2Name = findViewById(R.id.Player2);

        maximShots = findViewById(R.id.MaximShots);
        maxShotsValue = "5";

        generateData();

        spinnerPlayer1 = findViewById(R.id.spinnerPlayer1);
        SpinnerAdapter adapter = new SpinnerAdapter(lstSource, MainActivity.this);
        spinnerPlayer1.setAdapter(adapter);

        spinnerPlayer2 = findViewById(R.id.spinnerPlayer2);
        SpinnerAdapter adapter2 = new SpinnerAdapter(lstSource, MainActivity.this);
        spinnerPlayer2.setAdapter(adapter2);

        linearLayout1 = findViewById(R.id.LL1);
        linearLayout2 = findViewById(R.id.LL2);
        linearLayout2.setVisibility(View.GONE);

        remainingShotsPlayer1 = Integer.parseInt(maxShotsValue);
        p1Remaining = findViewById(R.id.P1remainingShots);
        p1Remaining.setText(getString(R.string.p1remainingshots, remainingShotsPlayer1));

        remainingShotsPlayer2 = Integer.parseInt(maxShotsValue);
        p2Remaining = findViewById(R.id.P2remainingShots);
        p2Remaining.setText(getString(R.string.p2remainingshots, remainingShotsPlayer2));
    }

    /**
     * This method generates the list view elements
     */
    int i;

    private void generateData() {
        for (i = 0; i < 21; i++) {
            lstSource.add(i + getString(R.string.points));
        }
        if (i == 21) {
            lstSource.add(25 + getString(R.string.points));
            i = i + 1;
            if (i == 22) {
                lstSource.add(50 + getString(R.string.points));
                i = 0;
            }
        }
    }

    /**
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
        player1Throw = true;
        remainingShots();
        if (finalValuePlayer1 < 21 && remainingShotsPlayer1 != 0) {
            scorePlayer1 = scorePlayer1 + finalValuePlayer1;
        } else {
            if (finalValuePlayer1 == 21 && remainingShotsPlayer1 != 0) {
                scorePlayer1 = scorePlayer1 + 25;
            } else {
                if (finalValuePlayer1 == 22 && remainingShotsPlayer1 != 0) {
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
        player1Throw = true;
        if (finalValuePlayer1 == 0 || finalValuePlayer1 == 21 || finalValuePlayer1 == 22) {
            Context context = getApplicationContext();
            CharSequence text = getString(R.string.toast1);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            remainingShots();
            if (finalValuePlayer1 < 21 && remainingShotsPlayer1 != 0) {
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
        player1Throw = true;
        if (finalValuePlayer1 == 0 || finalValuePlayer1 == 21 || finalValuePlayer1 == 22) {
            Context context = getApplicationContext();
            CharSequence text = getString(R.string.toast9);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            remainingShots();
            if (finalValuePlayer1 < 21 && remainingShotsPlayer1 != 0) {
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
        player2Throw = true;
        remainingShots();
        if (finalValuePlayer2 < 21 && remainingShotsPlayer2 != 0) {
            scorePlayer2 = scorePlayer2 + finalValuePlayer2;
        } else {
            if (finalValuePlayer2 == 21 && remainingShotsPlayer2 != 0) {
                scorePlayer2 = scorePlayer2 + 25;
            } else {
                if (finalValuePlayer2 == 22 && remainingShotsPlayer2 != 0) {
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
        player2Throw = true;
        remainingShots();
        if (finalValuePlayer2 == 0 || finalValuePlayer2 == 21 || finalValuePlayer2 == 22) {
            Context context = getApplicationContext();
            CharSequence text = getString(R.string.toast1);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            if (finalValuePlayer2 < 21 && remainingShotsPlayer2 != 0) {

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
        player2Throw = true;
        remainingShots();
        if (finalValuePlayer2 == 0 || finalValuePlayer2 == 21 || finalValuePlayer2 == 22) {
            Context context = getApplicationContext();
            CharSequence text = getString(R.string.toast9);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            if (finalValuePlayer2 < 21 && remainingShotsPlayer2 != 0) {
                scorePlayer2 = scorePlayer2 + 3 * finalValuePlayer2;
            }
        }
        displayForTeamB(scorePlayer2);
        spinnerPlayer2.setSelection(0);
    }

    /**
     * Reset the score for each Team, the spinner selection and sets the maxim shots number to 5
     */
    public void reset(View v) {
        scorePlayer1 = 0;
        displayForTeamA(scorePlayer1);
        scorePlayer2 = 0;
        displayForTeamB(scorePlayer2);
        player1Name.setText("");
        player2Name.setText("");
        spinnerPlayer1.setSelection(0);
        maxShotsValue = "5";
        remainingShotsPlayer1 = Integer.parseInt(maxShotsValue);
        p1Remaining.setText(getString(R.string.p1remainingshots, remainingShotsPlayer1));
        remainingShotsPlayer2 = Integer.parseInt(maxShotsValue);
        p2Remaining.setText(getString(R.string.p2remainingshots, remainingShotsPlayer2));
        maximShots.setText("");
    }

    /**
     * Counts down how many shots each team have
     */
    public void remainingShots() {
        if (player1Throw && remainingShotsPlayer1 != 0) {
            player1Throw = false;
            remainingShotsPlayer1 = remainingShotsPlayer1 - 1;
            p1Remaining.setText(getString(R.string.p1remainingshots, remainingShotsPlayer1));

        } else {
            if (player1Throw) {
                Context context = getApplicationContext();
                CharSequence text = getString(R.string.remainingShots) + remainingShotsPlayer1;
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                player1Throw = false;
            }
        }
        if (player2Throw && remainingShotsPlayer2 != 0) {
            player2Throw = false;
            remainingShotsPlayer2 = remainingShotsPlayer2 - 1;
            p2Remaining.setText(getString(R.string.p2remainingshots, remainingShotsPlayer2));

        } else {
            if (player2Throw && !player1Throw) {
                Context context = getApplicationContext();
                CharSequence text = getString(R.string.remainingShots) + remainingShotsPlayer2;
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                player2Throw = false;
            }
        }
    }

    /**
     * This method compares the score of the teams
     */
    public void compare(View v) {
        String namePlayer1 = player1Name.getText().toString();
        String namePlayer2 = player2Name.getText().toString();
        if (!namePlayer1.isEmpty() && !namePlayer2.isEmpty()) {
            if (namePlayer1.equals(namePlayer2)) {
                Context context = getApplicationContext();
                Toast.makeText(context, R.string.toast2, Toast.LENGTH_SHORT).show();
            } else {
                if (remainingShotsPlayer1 != 0 || remainingShotsPlayer2 != 0) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, R.string.toast3, Toast.LENGTH_LONG).show();
                } else {

                    if (scorePlayer2 > scorePlayer1) {
                        Context context = getApplicationContext();
                        CharSequence text = namePlayer2 + getString(R.string.toast4);
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    } else {
                        if (scorePlayer1 > scorePlayer2) {
                            Context context = getApplicationContext();
                            CharSequence text = namePlayer1 + getString(R.string.toast4);
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        } else {
                            if (scorePlayer1 == scorePlayer2) {
                                Context context = getApplicationContext();
                                CharSequence text = getString(R.string.toast5);
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            }
                        }
                    }
                }
            }
        } else {
            if (namePlayer1.isEmpty()) {
                Context context = getApplicationContext();
                Toast.makeText(context, R.string.toast6, Toast.LENGTH_SHORT).show();
            } else {
                if (namePlayer2.isEmpty()) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, R.string.toast7, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    /**
     * This method changes the maximum number of shots
     */
    public void changeScore(View view) {
        maxShotsValue = maximShots.getText().toString();
        if (!maxShotsValue.isEmpty()) {

            remainingShotsPlayer1 = Integer.parseInt(maxShotsValue);
            remainingShotsPlayer2 = Integer.parseInt(maxShotsValue);
            if (remainingShotsPlayer1 < 100 && remainingShotsPlayer2 < 100) {
                p1Remaining.setText(getString(R.string.p1remainingshots, remainingShotsPlayer1));
                p2Remaining.setText(getString(R.string.p2remainingshots, remainingShotsPlayer2));
            } else {
                Context context = getApplicationContext();
                Toast.makeText(context, R.string.toast8, Toast.LENGTH_SHORT).show();
            }
        } else {
            Context context = getApplicationContext();
            Toast.makeText(context, R.string.toast10, Toast.LENGTH_SHORT).show();
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

        if (!toggle.isChecked()) {
            linearLayout2.setVisibility(View.GONE);
            linearLayout1.setVisibility(View.VISIBLE);
        } else {
            linearLayout2.setVisibility(View.VISIBLE);
            linearLayout1.setVisibility(View.GONE);
        }
    }
}