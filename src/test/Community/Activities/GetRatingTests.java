package test.Community.Activities;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.UtilsHelpers;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetRatingTests extends EnvironmentHelper {
    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetRatings() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ActivitiesEndpoints.properties", "GET_RATING_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("post_id", 1639).
                log().ifValidationFails().
                when().
                request("GET", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                time(Matchers.lessThan(2000l)).
                extract().body();
    }
}
