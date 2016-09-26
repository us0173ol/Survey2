package com.bignerdranch.android.survey2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SurveyActivity extends AppCompatActivity {

    private Button mYesButton;
    private  Button mNoButton;
    private Button mResultsButton;
    private static final int REQUEST_RESULTS = 0;
    private static final int CONFIG_RESULTS = 1;  //To differentiate between the two Activities that return to this Activity


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
                startActivityForResult(launchResultsActivity, REQUEST_RESULTS);
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
                startActivityForResult(launchConfigActivity, CONFIG_RESULTS);
            }
        });

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK)  {
            //Which activity is returning data?
            if (requestCode == CONFIG_RESULTS) {
                //Get extra from Intent data, which should be the question
                //Change the question in this Activity

                TextView newQuestion = (TextView)findViewById(R.id.question_textview);
                newQuestion.setText(data.getStringExtra("question"));

            }


            if (requestCode == REQUEST_RESULTS) {

                //reset counts to the values provided,
                int yes = data.getIntExtra("YES", 0);
                int no = data.getIntExtra("NO", 0);

                yesCounter = yes;
                noCounter = no;
            }
        }

        if (resultCode == RESULT_CANCELED  && requestCode== REQUEST_RESULTS) {
            Toast.makeText(this, "Continuing survey", Toast.LENGTH_LONG).show();
        }

    }
}
