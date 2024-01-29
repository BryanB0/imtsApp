package com.example.imtsapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView welcomeMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.welcomeMessageTextView = findViewById(R.id.welcome_message);
        this.welcomeMessageTextView.setText(
                getResources().getText(R.string.HelloWorld) + " Solacroup"
        );
    }
}