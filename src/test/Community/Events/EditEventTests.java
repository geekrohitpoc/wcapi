package test.Community.Events;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.EventHelpers;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.community.events.EditEventFields;
import main.java.pojo.community.events.EditEvents;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class EditEventTests extends EnvironmentHelper {

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanEditEvent() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("EventsEndpoints.properties", "EDIT_EVENTS_ENDPOINT");
        ArrayList<Integer> categories = new ArrayList<>();
        categories.add(11);
        EditEventFields fields = EventHelpers.createBodyForEditFields("", "2021-12-31 10:00:00", "2021-12-31 12:00:00","this is what to expect","open","members","topic","virtual");
        EditEvents EditEvents = EventHelpers.createBodyForEditEvents("publish","New Running event","This is a running event",categories,fields);
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().all().
                when().
                body(EditEvents).
                request("POST", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
