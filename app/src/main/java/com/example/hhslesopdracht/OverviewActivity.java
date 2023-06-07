package com.example.hhslesopdracht;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hhslesopdracht.adapters.ShowAdapter;
import com.example.hhslesopdracht.models.Show;

import java.util.List;

public class OverviewActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcher;
    private RecyclerView recyclerView;
    private List<Show> shows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    shows.clear();
                    shows.addAll(Show.getShows(this));
                    recyclerView.getAdapter().notifyDataSetChanged();
                }
        );

        shows = Show.getShows(this);
        recyclerView = findViewById(R.id.overview_list_rv_id);
        ShowAdapter adapter = new ShowAdapter(shows);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(
                        this));

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