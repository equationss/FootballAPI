package FootballAPI;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Timezone {

    @Test
    public void Timezone(){

        String apiKey = "781dbb368amsh76aa4477e882173p1255a3jsn3757c2d59020"; // RapidAPI key

        // Sending the request and getting the response
        baseURI = "https://api-football-beta.p.rapidapi.com";
        given()
                .header("X-RapidAPI-Key", apiKey)  // Adding the API key as a header
                .get("/timezone")
                .then()
                .statusCode(200)
                .log().all();
    }
}
