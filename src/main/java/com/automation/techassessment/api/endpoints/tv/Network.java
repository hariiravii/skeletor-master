package com.automation.techassessment.api.endpoints.tv;

public class Network {

    private String name;
    private int id;
    private String logo_path;
    private String origin_country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogoPath() {
        return logo_path;
    }

    public void setLogoPath(String logo_path) {
        this.logo_path = logo_path;
    }

    public String getOriginCountry() {
        return origin_country;
    }

    public void setOriginCountry(String origin_country) {
        this.origin_country = origin_country;
    }

}
