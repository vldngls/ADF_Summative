package com.example.afd_summativeexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 2000; // Adjust the duration as needed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final ImageView logo = findViewById(R.id.logo);
        final Button startButton = findViewById(R.id.startButton);

        // Fade-in animation for the logo
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(1000);

        // Delayed start for the splash screen
        logo.startAnimation(fadeIn);
        new Handler().postDelayed(() -> {
            startButton.setVisibility(View.VISIBLE);
            startButton.startAnimation(fadeIn);
        }, SPLASH_DURATION);
    }

    public void onStartButtonClick(View view) {
        // Create an Intent to start the LoginPage activity
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
        finish(); // Optional: close the current activity
    }
}
