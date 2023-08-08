package FootballAPI.Players;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class PlayersStats {

    @Test
    public void PStats(){

        String apiKey = "781dbb368amsh76aa4477e882173p1255a3jsn3757c2d59020"; // RapidAPI key
        String PlayerID = "276"; //ID of Player
        String Season = "2019"; //Season Year

        // Sending the request and getting the response
        baseURI = "https://api-football-beta.p.rapidapi.com";
        given()
                .header("X-RapidAPI-Key", apiKey)  // Adding the API key as a header
                .get("/players?season=" + Season + "&id=" + PlayerID)
                .then()
                .statusCode(200)
                .body("response.player.name" , hasItem("Neymar"))
                .log().all();

    }
}
