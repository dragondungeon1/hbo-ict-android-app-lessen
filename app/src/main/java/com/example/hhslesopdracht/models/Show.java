package com.example.hhslesopdracht.models;

public class Show {

    private Integer id;

    private String name;

    private Integer seasons;

    private Character character;

    public Show() {

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


}