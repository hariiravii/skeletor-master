package com.automation.techassessment.api.endpoints.tv;

import java.util.List;

/*
    Results can lots of different objects. If you check the TV object you'll see the clear duplication. I'm not going to
    fix this, but I do recognize more work would be necessary to reduce the redundant objects.

    Note that I did use this class in search_nonEnglishName_itemFound without creating a new results object.
 */
public class TVResult {

    private String backdrop_path;
    private String first_air_date;
    private List<Integer> genre_ids = null;
    private int id;
    private String original_language;
    private String original_name;
    private String overview;
    private List<String> origin_country = null;
    private String poster_path;
    private double popularity;
    private String name;
    private double vote_average;
    private int vote_count;

    public String getBackdropPath() {
        return backdrop_path;
    }

    public void setBackdropPath(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getFirstAirDate() {
        return first_air_date;
    }

    public void setFirstAirDate(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public List<Integer> getGenreIds() {
        return genre_ids;
    }

    public void setGenreIds(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalLanguage() {
        return original_language;
    }

    public void setOriginalLanguage(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginalName() {
        return original_name;
    }

    public void setOriginalName(String original_name) {
        this.original_name = original_name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public List<String> getOriginCountry() {
        return origin_country;
    }

    public void setOriginCountry(List<String> origin_country) {
        this.origin_country = origin_country;
    }

    public String getPosterPath() {
        return poster_path;
    }

    public void setPosterPath(String poster_path) {
        this.poster_path = poster_path;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVoteAverage() {
        return vote_average;
    }

    public void setVoteAverage(double vote_average) {
        this.vote_average = vote_average;
    }

    public int getVoteCount() {
        return vote_count;
    }

    public void setVoteCount(int vote_count) {
        this.vote_count = vote_count;
    }
}
