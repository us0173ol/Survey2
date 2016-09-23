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


        final EditText userInput = (EditText)findViewById(R.id.edit_text_box);
        Button submit = (Button)findViewById(R.id.submit_button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent launchSurveyActivity = new Intent(ConfigActivity.this, SurveyActivity.class);
                launchSurveyActivity.putExtra("question", userInput.getText().toString());
                startActivity(launchSurveyActivity);
            }
        });

    }
}
