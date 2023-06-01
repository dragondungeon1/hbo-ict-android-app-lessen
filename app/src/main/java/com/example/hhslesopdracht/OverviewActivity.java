package com.example.hhslesopdracht;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OverviewActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
    }

    public void goToAddCharacterActivity(View view) {
//        where
        Intent intent = new Intent(this, AddCharacterActivity.class);

        //geef data door
        String data = "from overview";
        intent.putExtra("testData", data);
//        to
        startActivity(intent);
        launcher.launch(intent);
    }

    public void goToAddShowActivity(View view) {
//        where
        Intent intent = new Intent(this, AddShowActivity.class);

        //geef data door
        String data = "from overview";
        intent.putExtra("testData", data);
//        to
        startActivity(intent);
        launcher.launch(intent);
    }
}