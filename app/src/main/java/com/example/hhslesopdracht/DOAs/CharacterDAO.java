package com.example.hhslesopdracht.DOAs;

import com.example.hhslesopdracht.models.Character;

import java.util.List;
@Dao
public interface CharacterDAO {
    //crud methods

    @Insert
    void insert(Character character);

    @Update
    void update(Character character);

    @Delete
    void delete(Character character);

    @Query("SELECT * FROM character")
    List<Character> getAll();

    @Query("SELECT * FROM character WHERE id = :id")
    Character getById(int id);
}