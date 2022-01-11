package test.Profile;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.ProfileHelpers;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.profile.FollowUser;
import main.java.pojo.profile.UserFavActivities;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class UserFavActivityTests extends EnvironmentHelper {


    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserSeeUserFavActivities() throws IOException {
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        UserFavActivities userFavActivities = ProfileHelpers.creatBodyForUserFavActivities(ids);
        String ENDPOINT = UtilsHelpers.getProperties("ProfileEndpoints.properties", "USER_FAV_ACTIVITIES_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                body(userFavActivities).
                when().
                request("POST", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();
    }

}
