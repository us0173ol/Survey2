package com.bignerdranch.android.survey2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SurveyActivity extends AppCompatActivity {

    private Button mYesButton;
    private  Button mNoButton;
    private Button mResultsButton;
    private static final int REQUEST_RESULTS = 0;

    int yesCounter = 0;
    int noCounter = 0;
    private int getYesCounter;
    private int getNoCounter;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        mYesButton = (Button) findViewById(R.id.yes_button);
        mYesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                yesCounter++;
            }
        });

        mNoButton = (Button) findViewById(R.id.no_button);
        mNoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                noCounter++;
            }
        });
        mResultsButton = (Button) findViewById(R.id.results_button);
        mResultsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                int yesCount = yesCounter;
                int noCount = noCounter;
                Intent launchResultsActivity = new Intent(SurveyActivity.this, ResultsActivity.class);
                launchResultsActivity.putExtra("YesCounter", yesCount );
                launchResultsActivity.putExtra("NoCounter", noCount);
                startActivityForResult(launchResultsActivity,REQUEST_RESULTS);
            }

        });
        Intent launchIntent = getIntent();
        getYesCounter = launchIntent.getIntExtra("YesCounterRet",0);
        getNoCounter = launchIntent.getIntExtra("NoCounterRet",0);
        yesCounter = getYesCounter;
        noCounter = getNoCounter;

        Button changeQuestion = (Button)findViewById(R.id.change_question);
        changeQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchConfigActivity = new Intent(SurveyActivity.this, ConfigActivity.class);
                startActivity(launchConfigActivity);
            }
        });
        //TextView newQuestion = (TextView)findViewById(R.id.question_textview);
        //newQuestion.setText(getIntent().getExtras().getString("question"));

    }
}
