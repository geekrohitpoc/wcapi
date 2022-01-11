package test.Community.Others;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.UtilsHelpers;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class LeaveCommunityTests extends EnvironmentHelper {

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanLeaveCommunityTests() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("CommunityEndpoints.properties", "LEAVE_COMMUNITY_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("post_id",1660).
                log().ifValidationFails().
                when().
                request("DELETE", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();
    }

}
