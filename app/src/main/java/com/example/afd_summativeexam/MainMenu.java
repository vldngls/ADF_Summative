package com.example.afd_summativeexam;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Slam book Button
        findViewById(R.id.slambookMain).setOnClickListener(view -> {
            // Intent to start SlamBookMain activity
            Intent intent = new Intent(MainMenu.this, SlamBookMain.class);
            startActivity(intent);
        });


        // Logout TextView
        findViewById(R.id.logoutTextView).setOnClickListener(view -> {
            finish();  // Assuming you want to go back to the previous activity
        });
    }
}
