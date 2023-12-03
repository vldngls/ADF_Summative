package com.example.afd_summativeexam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class SlambookAct extends AppCompatActivity {

    private EditText editTextFavoriteColor;
    private Spinner spinnerFavoriteSnacks;
    private CheckBox checkBoxMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slambook);

        // Initialize UI elements
        editTextFavoriteColor = findViewById(R.id.editTextFavoriteColor);
        spinnerFavoriteSnacks = findViewById(R.id.spinnerFavoriteSnacks);
        checkBoxMovies = findViewById(R.id.checkBoxMovies);

        // Populate the spinner with snack options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.snack_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFavoriteSnacks.setAdapter(adapter);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the Submit button click event
                submitSlamBook();
            }
        });
    }

    private void submitSlamBook() {
        // Retrieve data from UI elements on the second page
        String favoriteColor = editTextFavoriteColor.getText().toString();
        String favoriteSnack = spinnerFavoriteSnacks.getSelectedItem().toString();
        boolean likesMovies = checkBoxMovies.isChecked();

        // Retrieve the name, gender, age, and course passed from the first activity
        String name = getIntent().getStringExtra("name");
        String gender = getIntent().getStringExtra("gender");
        String age = getIntent().getStringExtra("age");
        String course = getIntent().getStringExtra("course");

        // Customize the alert message based on gender
        String salutation = gender.equalsIgnoreCase("male") ? "bro" : "sis";
        String message = "Nice one " + salutation + "!\n" +
                "Hi " + name + " - " + age + " from " + course + ".\n\n" +
                "This is your slambook!\n" +
                "Favorite Color: " + favoriteColor + "\n" +
                "Favorite Snack: " + favoriteSnack + "\n" +
                "Likes movies?: " + (likesMovies ? "Yes" : "No") + "\n\n" +
                "Thanks!";

        new AlertDialog.Builder(this)
                .setTitle("Slam Book Submission")
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Optional: Add further actions on OK button click
                    }
                })
                .show();
    }
}
