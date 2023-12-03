package com.example.afd_summativeexam;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ExitSplash extends AppCompatActivity {

    private static final int SPLASH_DURATION = 5000; // Adjust the duration as needed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit_splash);

        TextView thankYouMessage = findViewById(R.id.thankYouMessage);

        // Fade-in animation for the "Thank You" message
        Animation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(1000);
        thankYouMessage.startAnimation(fadeIn);

        // Optional: You can add a delayed action before navigating to the LoginPage
        new Handler().postDelayed(() -> {
            navigateToLoginPage();
        }, SPLASH_DURATION);
    }

    private void navigateToLoginPage() {
        // Start the LoginPage activity
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);

        // Optional: Add flags to clear the back stack and finish the current activity
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        finish();
    }
}
