package FootballAPI.Players;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class TopScorer {

    @Test
    public void Scorer(){

        String apiKey = "781dbb368amsh76aa4477e882173p1255a3jsn3757c2d59020"; // RapidAPI key
        String Season = "2019"; // Season Number
        String League = "39"; //League Number

        // Sending the request and getting the response
        baseURI = "https://api-football-beta.p.rapidapi.com";
        given()
                .header("X-RapidAPI-Key", apiKey)  // Adding the API key as a header
                .get("/players/topscorers?season=" + Season + "&league=" + League)
                .then()
                .statusCode(200)
                .body("response.player.name" , hasItem("J. Vardy"))
                .log().all();

    }
}
