package FootballAPI;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItem;

public class Timezone {

    @Test
    public void FTimezone(){

        String apiKey = "781dbb368amsh76aa4477e882173p1255a3jsn3757c2d59020"; // RapidAPI key

        // Sending the request and getting the response
        baseURI = "https://api-football-beta.p.rapidapi.com";
        given()
                .header("X-RapidAPI-Key", apiKey)  // Adding the API key as a header
                .get("/timezone")
                .then()
                .statusCode(200)
                .body("response" , hasItem("Africa/Accra"))
                .log().all();
    }
}
