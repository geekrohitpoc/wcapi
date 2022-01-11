package test.Community.Events;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.EventHelpers;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.community.events.CreateEventFields;
import main.java.pojo.community.events.CreateEvents;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateEventTests extends EnvironmentHelper{

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanCreateEvent() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("EventsEndpoints.properties", "CREATE_EVENTS_ENDPOINT");
        ArrayList<Integer> categories = new ArrayList<>();
        categories.add(11);
        CreateEventFields fields = EventHelpers.createBodyForCreateFields("", "2021-11-13 10:00:00", "2021-11-13 12:00:00","this is what to expect","open","members","topic","virtual","created");
        CreateEvents createEvents = EventHelpers.createBodyForCreateEvent("publish","New Running event","This is a running event",categories,fields);
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().all().
                when().
                body(createEvents).
                request("POST", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(201).
                assertThat().
                extract().body();
    }


}
