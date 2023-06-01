package com.example.hhslesopdracht;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.hhslesopdracht.models.Character;
import com.example.hhslesopdracht.models.Show;

import java.util.Date;

public class AddCharacterActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_character);

        Intent intent = getIntent();
        String test  = intent.getStringExtra("testData");
        System.out.println(test);
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    System.out.println(result.getData().getStringExtra("message"));
                }
        );

    }

    public void save(View view) {
        EditText nameText = findViewById(R.id.add_character_input);
        //TODO ask jaap about date
//        EditText dateText = findViewById(R.id.editTextId);

        String name = nameText.getText().toString();
//        String dateOfBirth = dateText.getText().toString();
        Date dateOfBirth = new Date();
//        Date dateOfBirth = String.valueOf(dateText);
        Character character = new Character(name,dateOfBirth);
        System.out.println(character);
    }

    public void goTo(View view) {
        // sent signal to next frame
        Intent intent = new Intent();
        intent.putExtra("message", "return bericht");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}