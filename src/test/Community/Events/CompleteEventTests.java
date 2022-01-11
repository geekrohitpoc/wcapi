package test.Community.Events;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.EventHelpers;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.community.events.CompleteEvent;
import main.java.pojo.community.events.CompleteEventFields;
import main.java.pojo.community.events.FieldEvents;
import main.java.pojo.community.events.SaveLiveSessionId;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CompleteEventTests extends EnvironmentHelper {

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanCompleteEvents() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("EventsEndpoints.properties", "COMPLETE_EVENT_ENDPOINT");
        CompleteEventFields completeEventFields = EventHelpers.createBodyForCompleteEvents("", "completed");
        CompleteEvent completeEvent = EventHelpers.createBodyForCompleteEvent(completeEventFields);
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().all().
                when().
                body(completeEvent).
                request("POST", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
