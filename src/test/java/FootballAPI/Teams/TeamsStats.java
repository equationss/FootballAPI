package FootballAPI.Teams;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class TeamsStats {

    @Test
    public void Stat(){

        String apiKey = "781dbb368amsh76aa4477e882173p1255a3jsn3757c2d59020"; // RapidAPI key
        String League = "39"; // League ID
        String Season = "2019"; //Season Year
        String Team = "33"; //Team ID

        // Sending the request and getting the response
        baseURI = "https://api-football-beta.p.rapidapi.com";
        given()
                .header("X-RapidAPI-Key", apiKey)  // Adding the API key as a header
                .get("/teams/statistics?team=" + Team + "&season=" + Season + "&league=" + League)
                .then()
                .statusCode(200)
                .body("response.league.name" , equalTo("Premier League"))
                .log().all();

    }
}
