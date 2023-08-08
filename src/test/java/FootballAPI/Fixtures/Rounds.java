package FootballAPI.Fixtures;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Rounds {

    @Test
    public void rounds(){

        String apiKey = "781dbb368amsh76aa4477e882173p1255a3jsn3757c2d59020"; // RapidAPI key
        String LeagueID = "39"; // ID of League
        String Season = "2019"; //Season of League

        // Sending the request and getting the response
        baseURI = "https://api-football-beta.p.rapidapi.com";
        given()
                .header("X-RapidAPI-Key", apiKey)  // Adding the API key as a header
                .get("/fixtures/rounds?league=" + LeagueID + "&season=" + Season)
                .then()
                .statusCode(200)
                .body("parameters.league" , equalTo("39"))
                .log().all();



    }
}
