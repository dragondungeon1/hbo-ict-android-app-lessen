package com.example.hhslesopdracht.models;

import android.content.Context;

import com.example.hhslesopdracht.Database;

import java.util.ArrayList;
import java.util.List;

@Entity(foreignKeys = {
        @ForeignKey(entity = Character.class,
        //primary key column in the character table
        parentColumns = "id",
        //foreign key column in the show table
        childColumns = "characterId",
        onDelete = ForeignKey.SET_NULL)})

public class Show {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private String name;

    @ColumnInfo(name = "numberOfSeason")
    private Integer seasons;

    @Ignore
    private Character character;


    private Integer characterId;

    @Ignore
    public Show(String name, Integer seasons, Character character) {
        this.name = name;
        this.seasons = seasons;
        this.character = character;
    }

    public static void addShow(Show show, Context context) {
        Database.getDatabase(context).showDAO().insert(show);
    }

    public static List<Show> getShows(Context context) {

        List<Show> shows = Database.getDatabase(context).showDAO().getAll();
        for (int i = 0; i < shows.size(); i++) {
            int id = shows.get(i).getCharacterId();
            Character character = Database.getDatabase(context).characterDAO().getById(id);
            shows.get(i).setCharacter(character);
        }
        return shows;
    }

    public Show(Integer id) {
        this.id = id;
    }

    public Show(String name, Integer seasons) {
        this.name = name;
        this.seasons = seasons;
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seasons=" + seasons +
                ", character=" + character +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSeasons() {
        return seasons;
    }

    public Character getCharacter() {
        return character;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeasons(Integer seasons) {
        this.seasons = seasons;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }


    public Integer getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Integer characterId) {
        this.characterId = characterId;
    }
}
