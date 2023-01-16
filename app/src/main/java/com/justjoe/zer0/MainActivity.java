package com.justjoe.zer0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zer0.R;

import java.lang.Math;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private ImageButton countdownButton;
    private TextView highScoreText;
    private TextView trophyCountText;
    private TextView countdownText;
    private ImageView trophyImage;
    private SharedPreferences scorePref;

    private CountDownTimer countDownTimer;
    private final long startTimeInMilliseconds = 20000; // 10 seconds
    private String highScoreString = "10.00";
    private long timeLeftInMilliseconds = startTimeInMilliseconds; //10 seconds
    private boolean timerRunning;
    private boolean newGame = true;
    private boolean timerHitZero = false;
    private String timeLeftText = "10.00";
    private String trophyCountString = "0";
    private Integer trophyCount = 0;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        countdownButton = findViewById(R.id.countdown_button);
        countdownText = findViewById(R.id.countdown_text);
        highScoreText = findViewById(R.id.highScore);
        trophyCountText = findViewById(R.id.trophyCount);
        trophyImage = findViewById(R.id.trophy);

        scorePref = getSharedPreferences("myPref", Context.MODE_PRIVATE);
        highScoreText.setVisibility(View.VISIBLE);

        //saveGame();
        loadGame();
        if (trophyCount < 1) {
            highScoreText.setVisibility(View.VISIBLE);
            trophyCountText.setVisibility(View.INVISIBLE);
            trophyImage.setVisibility(View.INVISIBLE);
        } // if
        else {
            highScoreText.setVisibility(View.INVISIBLE);
            trophyCountText.setVisibility(View.VISIBLE);
            trophyImage.setVisibility(View.VISIBLE);
            trophyCountText.setText(trophyCountString);
        } // else


        view = this.getWindow().getDecorView();

        countdownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibe.vibrate(100);
                startStop();
            } // onClick
        });  //OnClickListener

        updateTimer();
    } // onCreate


    public void saveGame() {
        // Saves game
        scorePref.edit().putString("highScore", highScoreString).commit();
        scorePref.edit().putString("trophyCount", trophyCountString).commit();
    } // saveGame


    public void loadGame() {
        // load highScore
        highScoreString = scorePref.getString("highScore", "10.00"); //empty string is the default value
        highScoreText.setText(highScoreString);

        // load trophies
        trophyCountString = scorePref.getString("trophyCount", "0"); //empty string is the default value
        trophyCount = Integer.valueOf(trophyCountString);
        trophyCountText.setText(trophyCountString);
    } // loadScore


    public void startStop() {
        if (timerRunning) { // When the timer is running you can stop it
            newGame = false;
            stopTimer();
        } // if

        else if (!timerRunning && newGame) {
            resetTimer();
            startTimer();
        } // else if

        else {
            resetTimer();
        }
    } // startStop

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 10) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                view.setBackgroundResource(R.color.white); // changes background colour
                updateTimer();
            } // onTick

            @Override
            public void onFinish() {
                timerRunning = false;

            } // onFinish
        }.start(); // CountDownTimer

        timerRunning = true;
    } // startTimer

    public void stopTimer() {
        countDownTimer.cancel();
        timerRunning = false;

        if (Objects.equals(timeLeftText, "0.00")) {
            highScoreText.setVisibility(View.INVISIBLE);
            trophyCountText.setVisibility(View.VISIBLE);
            trophyImage.setVisibility(View.VISIBLE);
            trophyCount += 1;
            trophyCountString = ""+trophyCount;
            trophyCountText.setText(trophyCountString);
            saveGame();
        } // if

        if (Math.abs(Double.parseDouble(timeLeftText)) < Math.abs(Double.parseDouble(highScoreString))) {
            highScoreString = timeLeftText;
            highScoreText.setText(highScoreString);
            saveGame();
        } // if

    } // stopTimer

    public void resetTimer() {
        timeLeftInMilliseconds = startTimeInMilliseconds;
        updateTimer();
        newGame = true;
        timerRunning = false;
        timerHitZero= false;
    } // resetTimer


    public void updateTimer() {

        int millisecondsInMinutes = 60000;
        int millisecondsInSeconds = 1000;

        int seconds =  (int) (timeLeftInMilliseconds % millisecondsInMinutes) / millisecondsInSeconds; // find the remainder after the minutes i.e. the seconds, then divide by 1000 to get the seconds
        seconds -= 10; // makes the timer go to -10 rather than stopping at 0

        int milliseconds = (int) ((timeLeftInMilliseconds % millisecondsInMinutes) % millisecondsInSeconds) / 10; // same as before but this time modulo by 1000 to get the milliseconds

        if (seconds < 0){
            milliseconds = 100 - milliseconds; // makes the milliseconds counts upwards after 0
        } // if

        timeLeftText = "";


        if (seconds <= -10) {
            timeLeftText = "-10.0";
            newGame = true;
            timerRunning = false;
        } // if

        else {
            timeLeftText += seconds+"."+milliseconds;

            if (Double.parseDouble(timeLeftText) <= 0.0 && !timerHitZero) { // makes sure timer hits 0.00
                timerHitZero = true;
                view.setBackgroundResource(R.color.lime); // changes background colour
                timeLeftText = "0.00";
            } // if

            else if (milliseconds < 10 && Double.parseDouble(timeLeftText) > 0.0 && seconds < 1) {
                timeLeftText = seconds+".0"+milliseconds;
            } // if


            else if (Double.parseDouble(timeLeftText) < 0.0) { // Makes sure that the timer counts between 0 and -1
                timeLeftText = "";
                view.setBackgroundResource(R.color.white);
                seconds += 1;

                if (seconds <= -1){ // Makes sure there isn't a double minus sign in the text
                    timeLeftText += seconds+"."+milliseconds;
                } // if

                else {
                    if (milliseconds < 10) {
                        timeLeftText += "-"+seconds+".0"+milliseconds;
                    } // if
                    else {
                        timeLeftText += "-"+seconds+"."+milliseconds;
                    } // else
                } // else

            } // else if
        } // else

        //System.out.println(timeLeftText);
        countdownText.setText(timeLeftText);

    } // updateTimer


} // MainActivity
