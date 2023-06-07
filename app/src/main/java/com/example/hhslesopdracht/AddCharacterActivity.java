package com.example.hhslesopdracht;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.hhslesopdracht.models.Character;
import com.example.hhslesopdracht.models.Show;

import java.text.ParseException;
import java.util.Date;

public class AddCharacterActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_character);

        Intent intent = getIntent();
        String test = intent.getStringExtra("testData");
        System.out.println(test);
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    System.out.println(result.getData().getStringExtra("message"));
                }
        );

    }

    public void goTo(View view) {
        // sent signal to next frame
        Intent intent = new Intent();
        intent.putExtra("message", "return bericht");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    public void createCharacter(View view)
            throws ParseException {
        EditText nameET = findViewById(R.id.add_character_input);//addChar_name_et_id
        String name = nameET.getText().toString();
        EditText dobET = findViewById(R.id.editTextId);//addChar_dob_et_id
        String dob = dobET.getText().toString();
        SimpleDateFormat formatter =
                new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(dob);
//Voeg zelf validatie toe!
        Character character = new Character(name,date);
        Character.addCharacter(character, this);
        finish();
    }
}