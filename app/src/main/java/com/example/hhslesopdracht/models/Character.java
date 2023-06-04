package com.example.hhslesopdracht.models;

import java.util.ArrayList;
import java.util.Date;

public class Character {

    private Integer id;
    private String name;
    private Date dateOfBirth;
    private ArrayList<Show> shows = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    private static ArrayList<Character> characters = new ArrayList<Character>() {{
        add(new Character("Jon Snow"));
        add(new Character("Vincent Chase"));
        add(new Character("Mr. White"));
    }};

    public static void addCharacter(Character character) {
        characters.add(character);
    }

    public static ArrayList<Character> getCharacters() {
        return characters;
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
