package test.Community.Events;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.EventHelpers;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.community.events.FieldEvents;
import main.java.pojo.community.events.SaveLiveSessionId;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class SaveLiveSessionID extends EnvironmentHelper {

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanSaveLiveSessionIds() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("EventsEndpoints.properties", "SAVE_LIVE_SESSION_ID_ENDPOINT");
        FieldEvents fieldEvents = EventHelpers.createBodyForFieldEvents("4mynurdqHqbqGWHgq8Y9");
        SaveLiveSessionId saveLiveSessionId = EventHelpers.createBodyForSaveLiveSessionId(fieldEvents);
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().all().
                when().
                body(saveLiveSessionId).
                request("POST", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
