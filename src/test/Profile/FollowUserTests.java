package test.Profile;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.ProfileHelpers;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.profile.FollowUser;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class FollowUserTests extends EnvironmentHelper {
    FollowUser followUser = ProfileHelpers.createBodyForFollowUser(14,17);

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanFollow() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ProfileEndpoints.properties", "FOLLOW_USER_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                body(followUser).
                log().ifValidationFails().
                when().
                request("POST", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
