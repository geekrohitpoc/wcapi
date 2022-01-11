package test.Profile;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.ProfileHelpers;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.profile.AcceptFollower;
import main.java.pojo.profile.EditUserProfile;
import main.java.pojo.profile.Meta;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class EditUserProfileTests extends EnvironmentHelper {
    Meta meta = ProfileHelpers.createBodyForMeta("Purav", 111, "public", false, false, false, false);
    EditUserProfile editUserProfile = ProfileHelpers.createBodyForEditUserProfile("Naishad", "I love adventures", meta);

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanEditUserProfile() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ProfileEndpoints.properties", "EDIT_USER_PROFILE_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                body(editUserProfile).
                log().ifValidationFails().
                when().
                request("PUT", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();
    }

}

