package test.AthleteProgram;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.UtilsHelpers;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class SearchForAthleteTests extends EnvironmentHelper{

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanSearchForAthlete() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("AthleteProgramEndpoints.properties", "SEARCH_FOR_ATHLETE_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                queryParam("user_role", 87).
                header("Authorization", ACCESS_TOKEN).
                log().all().
                when().
                request("GET", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }

}