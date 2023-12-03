package com.example.afd_summativeexam;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

public class SlamBookMain extends AppCompatActivity {

    private EditText editTextName, editTextAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private Spinner spinnerCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slam_book_main);

        // Initialize UI elements
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        spinnerCourse = findViewById(R.id.spinnerCourse);

        // Populate the spinner with course options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.course_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCourse.setAdapter(adapter);

        Button btnProceed = findViewById(R.id.btnProceed);
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceedToSecondActivity();
            }
        });
    }

    private void proceedToSecondActivity() {
        // Retrieve data from UI elements on the first page
        String name = editTextName.getText().toString();
        String age = editTextAge.getText().toString();

        // Get selected gender
        RadioButton selectedGenderRadioButton = findViewById(radioGroupGender.getCheckedRadioButtonId());
        String gender = selectedGenderRadioButton == null ? "" : selectedGenderRadioButton.getText().toString();

        // Get selected course from the spinner
        String course = spinnerCourse.getSelectedItem().toString();

        // Create an Intent to start the SecondActivity
        Intent intent = new Intent(SlamBookMain.this, SlambookAct.class);

        // Pass data to the SecondActivity
        intent.putExtra("name", name);
        intent.putExtra("age", age);
        intent.putExtra("gender", gender);
        intent.putExtra("course", course);

        // Start the SecondActivity
        startActivity(intent);
    }
}
