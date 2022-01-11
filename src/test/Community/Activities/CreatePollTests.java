package test.Community.Activities;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.ActivityHelpers;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.community.activities.CreatePoll;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreatePollTests extends EnvironmentHelper {

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanCreatePoll() throws IOException {
        ArrayList<String> pollOptions = new ArrayList<>();
        pollOptions.add("Yes");
        pollOptions.add("No");
        CreatePoll createPoll = ActivityHelpers.createBodyForCreatePoll(1617, "Are you having fun ", pollOptions);

        String ENDPOINT = UtilsHelpers.getProperties("ActivitiesEndpoints.properties", "CREATE_POLL_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().all().
                when().
                body(createPoll).
                request("POST", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                time(Matchers.lessThan(2000l)).
                extract().body();

    }
}
