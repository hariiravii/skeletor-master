package com.automation.techassessment.api.tmdb;

import com.automation.techassessment.api.endpoints.ApiEndpoints;
import com.automation.techassessment.api.endpoints.tv.*;
import com.automation.techassessment.api.model.Genre;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import jdk.jfr.Enabled;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.automation.techassessment.api.errors.RestAssertions.assertCallSucceeds;


public class MovieSearchTest {
    private ApiEndpoints rest;

    @BeforeMethod
    public void setup() throws Exception {
        rest = ApiEndpoints.newBuilder().build();
    }


    @Test // Search by Movie Name.
    public void searchMovieByName() {
        final String searchQuery = "avenger";
        SearchResponseMovie search = assertCallSucceeds(rest.movie.searchMovie(searchQuery)).body();
        List<MovieResult> results = search.getResults();
        Assert.assertTrue(results.size() > 0, "There should be at least one search result");
        for(MovieResult result : results) {
            String originalTitle = result.getOriginal_title();
            Assert.assertTrue(originalTitle.toLowerCase().contains(searchQuery),
                    "The search results did not contain the name searched for.");
        }
    }

    @Test // Search by Movie Name with adult flag=true and verify any movies have adult flag true.
    public void searchMovieWithAdultFlagTrue() {
        final String searchQuery = "avengers vs x-men";
        final String adult = "true";
        boolean flag = false;
        SearchResponseMovie search = assertCallSucceeds(rest.movie.searchMovie(searchQuery , adult)).body();
        List<MovieResult> results = search.getResults();
        Assert.assertTrue(results.size() > 0, "There should be at least one search result");
        for(MovieResult result : results) {
            if (result.isAdult()) {
                flag = true;break;
            }
        }
        Assert.assertTrue(flag,"Search Result have Adult status true");
    }

    @Test // Search by Movie Name with adult flag=true and verify any movies have adult flag true.
    public void searchMovieWithAdultFlagFalse() {
        final String searchQuery = "alien avengers II";
        final String adult = "false";
        boolean flag = true;
        SearchResponseMovie search = assertCallSucceeds(rest.movie.searchMovie(searchQuery , adult)).body();
        List<MovieResult> results = search.getResults();
        Assert.assertTrue(results.size() > 0, "There should be at least one search result");
        for(MovieResult result : results) {
            Assert.assertFalse(result.isAdult(),"Movie have adult flag status as false");
        }

    }

    @Test // Search by Movie Name with numbers.
    public void searchMovieByNameWithNumbers() {
        final String searchQuery = "2 Fast 2 Furious";
        List<String> title=new ArrayList<String>();
        SearchResponseMovie search = assertCallSucceeds(rest.movie.searchMovie(searchQuery)).body();
        List<MovieResult> results = search.getResults();
        Assert.assertTrue(results.size() > 0, "There should be at least one search result");
        for(MovieResult result : results) {
            title.add(result.getOriginal_title());
        }
        Assert.assertTrue(title.contains("2 Fast 2 Furious"), "Search Result contain '2 Fast 2 Furious' Movie");
    }

    @Test // Search by Movie Name with long character above 50 char.
    public void searchMovieByNameWithLongCharcterLenght() {
        final String searchQuery = "Borat: Cultural Learnings of America for Make Benefit Glorious Nation of Kazakhstan";
        List<String> title=new ArrayList<String>();
        SearchResponseMovie search = assertCallSucceeds(rest.movie.searchMovie(searchQuery)).body();
        List<MovieResult> results = search.getResults();
        Assert.assertTrue(results.size() > 0, "There should be at least one search result");
        for(MovieResult result : results) {
            title.add(result.getTitle());
        }
        Assert.assertTrue(title.contains("Borat: Cultural Learnings of America for Make Benefit Glorious Nation of Kazakhstan"), "Search Result contain Movie Name");
    }

    @Test // test case for short length
    public void searchMovieByNameWithShortCharcterLength() {
    }

    @Test // Name with Special Character
    public void searchMovieByNameWithSpecialCharacter() {
        final String searchQuery = "Rock 'n' Roll Revue";
        List<String> title=new ArrayList<String>();
        SearchResponseMovie search = assertCallSucceeds(rest.movie.searchMovie(searchQuery)).body();
        List<MovieResult> results = search.getResults();
        Assert.assertTrue(results.size() > 0, "There should be at least one search result");
        for(MovieResult result : results) {
            title.add(result.getTitle());
        }
        Assert.assertTrue(title.contains("Rock 'n' Roll Revue"), "Search Result contain Movie Name");
    }

    @Test(enabled=false) // Search Movie Name with empty string
    public void searchMovieWithEmptyString() {
        final String searchQuery = "";
        SearchResponseMovie search = assertCallSucceeds(rest.movie.searchMovie(searchQuery)).body();
        // Need to Modify the RestAssertions Class to return "errors": ["query must be provided"]
    }


    @Test(enabled=false) // Search Movie Name with null
    public void searchMovieWithNULL() {
        final String searchQuery = null;
        SearchResponseMovie search = assertCallSucceeds(rest.movie.searchMovie(searchQuery)).body();
        // Need to Modify the RestAssertions Class to return "errors": ["query must be provided"]
    }

    @Test // Search Movie Name with invalid Endpoint
    public void searchMovieWithInValidEndPoint() {
        final String searchQuery = "avengers";
        // Modify the movie endpoint and pass the search request
    }

    }
