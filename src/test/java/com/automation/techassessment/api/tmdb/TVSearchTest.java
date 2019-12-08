package com.automation.techassessment.api.tmdb;

import com.automation.techassessment.api.endpoints.ApiEndpoints;
import com.automation.techassessment.api.endpoints.tv.TVResponse;
import com.automation.techassessment.api.endpoints.tv.TVResult;
import com.automation.techassessment.api.endpoints.tv.SearchResponseTV;
import com.automation.techassessment.api.model.Genre;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import static com.automation.techassessment.api.errors.RestAssertions.assertCallSucceeds;


public class TVSearchTest {
    private ApiEndpoints rest;

    @BeforeMethod
    public void setup() throws Exception {
        rest = ApiEndpoints.newBuilder().build();
    }

    @Test(dataProvider = "genreList")
    public void tv_genreList_verifyMultipleGenresAreReturned(String genre) throws IOException {
        final String gameOfThronesID = "1399";

        TVResponse tvResponse = assertCallSucceeds(rest.tv.getTVShowById(gameOfThronesID)).body();
        List<Genre> genres = tvResponse.getGenres();

        Assert.assertTrue(genres.stream().anyMatch(g -> g.getName().equals(genre)),
                "The expected " + genre + " was not found within the Genre list for this TV show.");
    }

    @Test
    public void search_nonEnglishName_itemFound() {
        final String searchQuery = "ドリフェス!";
        final String dreamFestival = "Dream Festival!";

        SearchResponseTV search = assertCallSucceeds(rest.tv.searchTV(searchQuery)).body();
        List<TVResult> results = search.getResults();

        Assert.assertTrue(results.size() > 0, "There should be at least one search result");
        for(TVResult result : results) {
            String showName = result.getName();
            Assert.assertTrue(showName.contains(dreamFestival),
                    "The search results did not contain the name searched for.");
        }
    }

    @Test // Adding pagination to request & verify the page number and have at least one response.
    public void searchWithPagination() {
        final String searchQuery = "the kingdom";
        final String page="2";
        SearchResponseTV search = assertCallSucceeds(rest.tv.searchTV(searchQuery , page)).body();
        List<TVResult> results = search.getResults();
        Integer pagenumber=search.getPage();
        Assert.assertTrue((page.equals(String.valueOf(pagenumber))) , "verify page number");
        Assert.assertTrue(results.size() > 0, "There should be at least one search result");

    }

    @Test // Invalid keyword with empty result set .
    public void searchResponseWithEmptySet() {
        final String searchQuery = "\"\"";
        SearchResponseTV search = assertCallSucceeds(rest.tv.searchTV(searchQuery)).body();
        List<TVResult> results = search.getResults();
        Assert.assertTrue(results.size() == 0, "There should be at least Zero result set");
    }

    @DataProvider
    public Object[][] genreList() {
        return new Object[][]{
                {"Sci-Fi & Fantasy"}, {"Drama"}, {"Action & Adventure"}
        };
    }
}
