package FootballAPI.Fixtures;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class Prediction {


    @Test
    public void FPrediction (){

        String apiKey = "781dbb368amsh76aa4477e882173p1255a3jsn3757c2d59020"; // RapidAPI key
        String Fix = "157462"; // Fixture Number

        // Sending the request and getting the response
        baseURI = "https://api-football-beta.p.rapidapi.com";
        given()
                .header("X-RapidAPI-Key", apiKey)  // Adding the API key as a header
                .get("/predictions?fixture=" + Fix)
                .then()
                .statusCode(200)
                .body("response.predictions.winner.name" , hasItem("Paris Saint Germain"))
                .log().all();


    }
}
