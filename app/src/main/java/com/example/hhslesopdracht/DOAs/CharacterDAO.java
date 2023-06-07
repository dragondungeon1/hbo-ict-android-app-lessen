package com.example.hhslesopdracht.DOAs;

import com.example.hhslesopdracht.models.Show;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ShowDAO {
    //crud methods

    @Insert
    void insert(Show show);

    @Update
    void update(Show show);

    @Delete
    void delete(Show show);

    @Query("SELECT * FROM show")
    List<Show> getAll();

    @Query("SELECT * FROM show WHERE id = :id")
    Show getById(int id);

}
