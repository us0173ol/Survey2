package com.bignerdranch.android.survey2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    private int returnYes;
    private int returnNo;
    private Button mResetResultsButton;
    private Button mContinueSurveyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent launchIntent = getIntent();
        returnYes = launchIntent.getIntExtra("YesCounter",0);
        returnNo = launchIntent.getIntExtra("NoCounter",0);
        TextView displayCounter = (TextView)findViewById(R.id.results_textview);
        displayCounter.setText("Yes: " + returnYes + " No: " + returnNo);

        resetResultsButton();

        continueSurveyButton();


    }

    private void continueSurveyButton() {
        mResetResultsButton = (Button) findViewById(R.id.continue_button);
        mResetResultsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent launchSurveyActivity = new Intent(ResultsActivity.this, SurveyActivity.class);
                launchSurveyActivity.putExtra("YesCounterRet", returnYes );
                launchSurveyActivity.putExtra("NoCounterRet", returnNo);
                startActivity(launchSurveyActivity);
            }
        });
    }

    private void resetResultsButton() {
        mResetResultsButton = (Button)findViewById(R.id.reset_button);
        mResetResultsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                returnYes = 0;
                returnNo = 0;
                Intent launchSurveyActivity = new Intent(ResultsActivity.this, SurveyActivity.class);
                startActivity(launchSurveyActivity);
            }
        });


    }
}
