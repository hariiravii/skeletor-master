package com.automation.techassessment.api.model;

public class ProductionCompany {

    private int id;
    private String logo_path;
    private String name;
    private String origin_country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getlogo_path() {
        return logo_path;
    }

    public void setlogo_path(String logo_path) {
        this.logo_path = logo_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getorigin_country() {
        return origin_country;
    }

    public void setorigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

}
