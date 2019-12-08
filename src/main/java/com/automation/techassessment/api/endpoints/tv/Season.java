package com.automation.techassessment.api.endpoints.tv;

public class Season {

    private String air_date;
    private int episode_count;
    private int id;
    private String name;
    private String overview;
    private String poster_path;
    private int season_number;

    public String getair_date() {
        return air_date;
    }

    public void setair_date(String air_date) {
        this.air_date = air_date;
    }

    public int getepisode_count() {
        return episode_count;
    }

    public void setepisode_count(int episode_count) {
        this.episode_count = episode_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getposter_path() {
        return poster_path;
    }

    public void setposter_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public int getseason_number() {
        return season_number;
    }

    public void setseason_number(int season_number) {
        this.season_number = season_number;
    }

}
