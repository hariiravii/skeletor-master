package com.automation.techassessment.api.model;

import java.util.ArrayList;


public class Images  {
    private String base_url;
    private String secure_base_url;
    private ArrayList<String> backdrop_sizes;
    private ArrayList<String> logo_sizes;
    private ArrayList<String> poster_sizes;
    private ArrayList<String> profile_sizes;
    private ArrayList<String> still_sizes;

    //<editor-fold desc="Getters and Setters">
    public String getBase_url() {
        return base_url;
    }

    public void setBase_url(String base_url) {
        this.base_url = base_url;
    }

    public String getSecure_base_url() {
        return secure_base_url;
    }

    public void setSecure_base_url(String secure_base_url) {
        this.secure_base_url = secure_base_url;
    }

    public ArrayList<String> getBackdrop_sizes() {
        return backdrop_sizes;
    }

    public void setBackdrop_sizes(ArrayList<String> backdrop_sizes) {
        this.backdrop_sizes = backdrop_sizes;
    }

    public ArrayList<String> getLogo_sizes() {
        return logo_sizes;
    }

    public void setLogo_sizes(ArrayList<String> logo_sizes) {
        this.logo_sizes = logo_sizes;
    }

    public ArrayList<String> getPoster_sizes() {
        return poster_sizes;
    }

    public void setPoster_sizes(ArrayList<String> poster_sizes) {
        this.poster_sizes = poster_sizes;
    }

    public ArrayList<String> getProfile_sizes() {
        return profile_sizes;
    }

    public void setProfile_sizes(ArrayList<String> profile_sizes) {
        this.profile_sizes = profile_sizes;
    }

    public ArrayList<String> getStill_sizes() {
        return still_sizes;
    }

    public void setStill_sizes(ArrayList<String> still_sizes) {
        this.still_sizes = still_sizes;
    }
    //</editor-fold>
}