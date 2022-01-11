package test.Profile;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.UtilsHelpers;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetPeopleWhoLikedPostsTests extends EnvironmentHelper {

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetPeopleWhoLikedPosts() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ProfileEndpoints.properties", "PEOPLE_WHO_LIKED_POST_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                queryParam("post_id", 98).
                queryParam("search", "v").
                queryParam("page", 1).
                queryParam("per_page", 10).
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                when().
                request("GET", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
