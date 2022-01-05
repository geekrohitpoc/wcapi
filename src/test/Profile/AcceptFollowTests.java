package test.Profile;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.ProfileHelpers;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.profile.AcceptFollower;
import main.java.pojo.profile.FollowUser;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class AcceptFollowTests extends EnvironmentHelper {
    AcceptFollower acceptFollower = ProfileHelpers.createBodyForAcceptFollower(68, 17);

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserAcceptFollow() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ProfileEndpoints.properties", "ACCEPT_FOLLOW_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                body(acceptFollower).
                log().all().
                when().
                request("POST", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
