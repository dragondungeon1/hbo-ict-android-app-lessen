package com.example.hhslesopdracht;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.hhslesopdracht.models.Show;

public class AddShowActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_show);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    System.out.println(result.getData().getStringExtra("message"));
                }
        );
    }

    public void save(View view) {
        EditText nameEditText = findViewById(R.id.main_name_et_id);
        EditText seasonsEditText = findViewById(R.id.main_seasons_et_id);

        String name = nameEditText.getText().toString();
        String seasons = seasonsEditText.getText().toString();
        int seasonsInt = Integer.parseInt(seasons);

        Show show = new Show(name, seasonsInt);
        System.out.println(show);

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

}