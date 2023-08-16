package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    String buttonvalue;
    Button startBtn;
    private CountDownTimer countDownTimer;
    TextView mTextview;
    private boolean mTimerunning;
    private long mTimeleftinms;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent=getIntent();
        buttonvalue=intent.getStringExtra("value");

        int intvalue=Integer.valueOf(buttonvalue);

        switch(intvalue){
            case 1:
                setContentView(R.layout.activity_mountain_climber);
                break;
            case 2:
                setContentView(R.layout.activity_basic_crunches);
                break;
            case 3:
                setContentView(R.layout.activity_bench_dips);
                break;
            case 4:
                setContentView(R.layout.activity_bicycle_crunches);
                break;
            case 5:
                setContentView(R.layout.activity_leg_raises);
                break;
            case 6:
                setContentView(R.layout.activity_althealtouch);
                break;
            case 7:
                setContentView(R.layout.activity_lupcrunches);
                break;
            case 8:
                setContentView(R.layout.activity_situp);
                break;
            case 9:
                setContentView(R.layout.activity_altvups);
                break;
            case 10:
                setContentView(R.layout.activity_plankrotation);
                break;
            case 11:
                setContentView(R.layout.activity_plankwithll);
                break;
            case 12:
                setContentView(R.layout.activity_russiantwist);
                break;
            case 13:
                setContentView(R.layout.activity_bridge);
                break;
            case 14:
                setContentView(R.layout.activity_vlcrunches);
                break;
            case 15:
                setContentView(R.layout.activity_windmill);
                break;
        }

        startBtn=findViewById(R.id.startButton);
        mTextview=findViewById(R.id.timer);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerunning){
                    stoptimer();

                }
                else {
                    startTimer();

                }
            }
        });
    }

    private void stoptimer(){
        countDownTimer.cancel();
        mTimerunning=false;
        startBtn.setText("START");
    }

    private void startTimer(){
        final CharSequence value1=mTextview.getText();
        String number1=value1.toString();
        String number2=number1.substring(0,2);
        String number3=number1.substring(3,5);
        final int number=Integer.valueOf(number2) * 60 + Integer.valueOf(number3);
        mTimeleftinms=number*1000;
        countDownTimer=new CountDownTimer(mTimeleftinms,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeleftinms=millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {
                int newvalue=Integer.valueOf(buttonvalue)+1;
                if (newvalue<=7){
                    Intent intent=new Intent(ThirdActivity.this,ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }
                else {
                    newvalue=1;
                    Intent intent=new Intent(ThirdActivity.this,ThirdActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value",String.valueOf(newvalue));
                    startActivity(intent);
                }

            }
        }.start();
        startBtn.setText("PAUSE");
        mTimerunning=true;
    }

    private void updateTimer(){
        int minutes=(int) mTimeleftinms/60000;
        int seconds=(int) mTimeleftinms%60000 /1000;
        String timeLefttext="";
        if (minutes<10)
            timeLefttext="0";
        timeLefttext=timeLefttext+minutes+":";
        if (seconds<10)
            timeLefttext+=0;
        timeLefttext+=seconds;
        mTextview.setText(timeLefttext);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}