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
        //TODO fix display counter to display the proper results
        resetResultsButton();
        //Why does my continue survey button return to my original question?
        continueSurveyButton();


    }

    private void continueSurveyButton() {
        mContinueSurveyButton = (Button) findViewById(R.id.continue_button);
        mContinueSurveyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                setResult(RESULT_CANCELED, null);
                finish();
//                Intent launchSurveyActivity = new Intent(ResultsActivity.this, SurveyActivity.class);
//                launchSurveyActivity.putExtra("YesCounterRet", returnYes );
//                launchSurveyActivity.putExtra("NoCounterRet", returnNo);
//                startActivity(launchSurveyActivity);
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


                //This is similar to TapTheSquare returns data.
                Intent resultIntent = new Intent();       //This ends up as the Intent data in onActivityResult
                resultIntent.putExtra("NO", returnNo);
                resultIntent.putExtra("YES", returnYes);



                setResult(RESULT_OK, resultIntent);
                // RESULT_OK ends up as int resultCode, resultIntent ends up as Intent data
                //public void onActivityResult(int requestCode, int resultCode, Intent data) {


                finish();

                //Intent launchSurveyActivity = new Intent(ResultsActivity.this, SurveyActivity.class);
                //startActivity(launchSurveyActivity);
            }
        });


    }
}
