package com.automation.techassessment.api.endpoints.tv;

import com.automation.techassessment.api.model.TMDbObject;

import java.util.List;

public class SearchResponseMovie implements TMDbObject {

    private int page;
    private int total_results;
    private int total_pages;
    private List<MovieResult> results = null;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return total_results;
    }

    public void setTotalResults(int total_results) {
        this.total_results = total_results;
    }

    public int getTotalPages() {
        return total_pages;
    }

    public void setTotalPages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<MovieResult> getResults() {
        return results;
    }

    public void setResults(List<MovieResult> results) {
        this.results = results;
    }

}