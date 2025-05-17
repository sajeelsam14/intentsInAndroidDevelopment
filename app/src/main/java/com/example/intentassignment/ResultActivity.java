package com.example.intentassignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    EditText inputResult;
    Button returnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        inputResult = findViewById(R.id.editTextResult);
        returnResult = findViewById(R.id.buttonReturn);

        returnResult.setOnClickListener(v -> {
            String resultData = inputResult.getText().toString();
            if (!resultData.isEmpty()) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("resultData", resultData);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            } else {
                inputResult.setError("Input can't be empty!");
            }
        });
    }
}
