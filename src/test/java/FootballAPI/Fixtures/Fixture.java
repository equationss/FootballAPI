package FootballAPI.Fixtures;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class Fixture {

    @Test
    public void fixtures(){

        String apiKey = "781dbb368amsh76aa4477e882173p1255a3jsn3757c2d59020"; // RapidAPI key
        String Date = "2020-02-06"; // Date of Fixture

        // Sending the request and getting the response
        baseURI = "https://api-football-beta.p.rapidapi.com";
        given()
                .header("X-RapidAPI-Key", apiKey)  // Adding the API key as a header
                .get("/fixtures?date=" + Date)
                .then()
                .statusCode(200)
                .body("response.fixture.referee." , hasItem("R. Rivero"))
                .log().all();



    }
}
