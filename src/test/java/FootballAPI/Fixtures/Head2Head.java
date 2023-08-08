package FootballAPI.Fixtures;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class Head2Head {

    @Test
    public void H2H(){

        String apiKey = "781dbb368amsh76aa4477e882173p1255a3jsn3757c2d59020"; // RapidAPI key
        String Team1 = "33"; // Team Number
        String Team2 = "34"; //Team Number
        String LastNumber = "10";
        String Status = "ft";

        // Sending the request and getting the response
        baseURI = "https://api-football-beta.p.rapidapi.com";
        given()
                .header("X-RapidAPI-Key", apiKey)  // Adding the API key as a header
                .get("/fixtures/headtohead?h2h=" + Team1 +"-" + Team2 + "&last=" + LastNumber + "&status=" + Status)
                .then()
                .statusCode(200)
                .body("response.fixture.referee" , hasItem("S. Attwell"))
                .log().all();



    }
}
