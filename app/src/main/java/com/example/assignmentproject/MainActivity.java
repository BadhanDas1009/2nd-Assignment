package com.example.assignmentproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import com.example.assignmentproject.R;

public class MainActivity extends AppCompatActivity {

    CheckBox musicCheckBox, sportsCheckBox, moviesCheckBox;
    RadioGroup genderRadioGroup;
    RatingBar ratingBar;
    SeekBar seekBar;
    Switch notificationsSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musicCheckBox = findViewById(R.id.checkbox_music);
        sportsCheckBox = findViewById(R.id.checkbox_sports);
        moviesCheckBox = findViewById(R.id.checkbox_movies);

        genderRadioGroup = findViewById(R.id.radioGroup);

        ratingBar = findViewById(R.id.ratingBar);

        seekBar = findViewById(R.id.seekBar);

        notificationsSwitch = findViewById(R.id.switch_notifications);

        musicCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "Music Selected", Toast.LENGTH_SHORT).show();
            }
        });

        sportsCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "Sports Selected", Toast.LENGTH_SHORT).show();
            }
        });

        moviesCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "Movies Selected", Toast.LENGTH_SHORT).show();
            }
        });

        genderRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = findViewById(checkedId);
            String selectedGender = selectedRadioButton.getText().toString();
            Toast.makeText(this, "Selected Gender: " + selectedGender, Toast.LENGTH_SHORT).show();
        });

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) ->
                Toast.makeText(this, "Rating: " + rating, Toast.LENGTH_SHORT).show()
        );

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(MainActivity.this, "Volume: " + progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        notificationsSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String message = isChecked ? "Notifications ON" : "Notifications OFF";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        });
    }
}
