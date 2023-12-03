package com.example.afd_summativeexam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        Button startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(view -> onStartButtonClick());
    }

    public void onStartButtonClick() {
        // Retrieve email and password
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Check if email or password is empty
        if (email.isEmpty() || password.isEmpty()) {
            // Display a Toast message indicating input is required
            Toast.makeText(this, "Input required", Toast.LENGTH_SHORT).show();
        } else {
            // Here, you can perform any login/authentication logic if required

            // Redirect to MainMenu activity
            Intent intent = new Intent(this, MainMenu.class);
            startActivity(intent);
        }
    }
}
