package com.example.afd_summativeexam;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartButtonClick(View view) {
        // Create an Intent to start the LoginPage activity
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }
}
