package com.bignerdranch.android.survey2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConfigActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        //Edit text boxes that will take user input and use it to display new question and answers
        final EditText userInput = (EditText)findViewById(R.id.edit_text_box);
        final EditText answer1 = (EditText)findViewById(R.id.editText2);
        final EditText answer2 = (EditText) findViewById(R.id.editText3);
        Button submit = (Button)findViewById(R.id.submit_button);
        //submit button to finalize and send user input to surveyActivity
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent launchSurveyActivity = new Intent(ConfigActivity.this, SurveyActivity.class);
//                launchSurveyActivity.putExtra("question", userInput.getText().toString());
//                startActivity(launchSurveyActivity);

                Intent newConfig = new Intent();
                newConfig.putExtra("question", userInput.getText().toString());
                newConfig.putExtra("answer1",answer1.getText().toString());
                newConfig.putExtra("answer2",answer2.getText().toString());
                setResult(RESULT_OK, newConfig);
                finish();


            }
        });

    }
}