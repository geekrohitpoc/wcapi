package test.Profile;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.UtilsHelpers;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class RemoveFollowerTests extends EnvironmentHelper {

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanRemoveFollower() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ProfileEndpoints.properties", "REMOVE_FOLLOWER_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                queryParam("user_id", 10).
                header("Authorization", ACCESS_TOKEN).
                log().all().
                when().
                request("DELETE", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
