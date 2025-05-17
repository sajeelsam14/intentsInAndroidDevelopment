package com.example.intentassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView receivedText, resultText;
    Button sendToResultActivity, backToMainActivity;

    public static final int RESULT_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        receivedText = findViewById(R.id.textReceived);
        resultText = findViewById(R.id.textResult);
        sendToResultActivity = findViewById(R.id.buttonSendResult);
        backToMainActivity = findViewById(R.id.buttonBackToMain);

        String data = getIntent().getStringExtra("message");
        if (data != null && !data.isEmpty()) {
            receivedText.setText("Received: " + data);
        }

        sendToResultActivity.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ResultActivity.class);
            startActivityForResult(intent, RESULT_REQUEST_CODE);
        });

        backToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this , MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_REQUEST_CODE && resultCode == RESULT_OK) {
            String result = data.getStringExtra("resultData");
            resultText.setText("Result from ResultActivity: " + result);
        }
    }
}
