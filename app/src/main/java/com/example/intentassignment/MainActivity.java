package com.example.intentassignment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextInput;
    Button goToSecondActivity, openWeb, shareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);
        goToSecondActivity = findViewById(R.id.buttonGoToSecond);
        openWeb = findViewById(R.id.buttonOpenWeb);
        shareText = findViewById(R.id.buttonShare);

        goToSecondActivity.setOnClickListener(v -> {
            String message = editTextInput.getText().toString();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("message", message);
            startActivity(intent);
        });

        // Implicit Intent to open web page
        openWeb.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.example.com"));
            startActivity(browserIntent);
        });

        shareText.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Check this out!");
            startActivity(Intent.createChooser(shareIntent, "Share via"));
        });
    }
}
