package com.example.hhslesopdracht;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hhslesopdracht.models.Character;
import com.example.hhslesopdracht.models.Show;

import java.text.ParseException;

public class AddShowActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_show);

        Spinner spinner = findViewById(R.id.
                addshow_characters_spnr_id);
        ArrayAdapter<Character> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.
                                simple_spinner_dropdown_item,
                        Character.
                                getCharacters(this));
        spinner.setAdapter(adapter);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    System.out.println(result.getData().getStringExtra("message"));
                }
        );
    }

    public void createShow(View view) throws ParseException {
        EditText nameEditText = findViewById(R.id.main_name_et_id);
        EditText seasonsEditText = findViewById(R.id.main_seasons_et_id);
        //get character from spinner
        Spinner spinner = findViewById(R.id.
                addshow_characters_spnr_id);
        Character character = (Character) spinner.getSelectedItem();

        String name = nameEditText.getText().toString();
        String seasons = seasonsEditText.getText().toString();
        int seasonsInt = Integer.parseInt(seasons);

        Show show = new Show(name, seasonsInt, character);
        show.setCharacterId(character.getId());


        Show.addShow(show, this);
        System.out.println(Show.getShows(this));
        finish();
    }

    public void goToAddCharacterActivity(View view) {
//        where
        Intent intent = new Intent(this, AddCharacterActivity.class);

        //geef data door
        String data = "data";
        intent.putExtra("testData", data);
//        to
        startActivity(intent);
        launcher.launch(intent);
    }

    public void gotToOverviewActivity(View view) {
//        where
        Intent intent = new Intent(this, OverviewActivity.class);

        //geef data door
        String data = "data";
        intent.putExtra("testData", data);
//        to
        startActivity(intent);
        launcher.launch(intent);
    }

}