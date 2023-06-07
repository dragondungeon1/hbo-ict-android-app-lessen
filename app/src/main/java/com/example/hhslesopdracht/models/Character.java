package com.example.hhslesopdracht.models;

import android.content.Context;

import com.example.hhslesopdracht.Database;
import com.example.hhslesopdracht.converters.Converter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//needed for Room
@Entity
public class Character {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String name;

    @TypeConverters({Converter.class})
    private Date dateOfBirth;

    @Ignore
    private ArrayList<Show> shows = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public static void addCharacter(Character character, Context context) {
        Database.getDatabase(context).characterDAO().insert(character);
    }

    public static List<Character> getCharacters(Context context) {
        return Database.getDatabase(context).characterDAO().getAll();
    }

    @Override
    public String toString() {
        return getName();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public ArrayList<Show> getShows() {
        return shows;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setShows(ArrayList<Show> shows) {
        this.shows = shows;
    }
}
