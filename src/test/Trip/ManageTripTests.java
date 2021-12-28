package test.Trip;

import main.java.helpers.*;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.annotations.Test;
import main.java.pojo.trip.*;

import static io.restassured.RestAssured.given;

public class ManageTripTests extends EnvironmentHelper {
    public static final String ENDPOINT = "/api/record/ManageTrip";
    Coordinates startCoordinates = CommonHelpers.createBodyForCoordinates(18.519627479345335,  73.93235133787392);
    Coordinates endCoordinates = CommonHelpers.createBodyForCoordinates(18.519627479345335,  73.93235133787392);
    Start start = CommonHelpers.createBodyForStart("Season Mall, Magarpatta City", startCoordinates, "2021-08-05 10:12:58");
    End end = CommonHelpers.createBodyForEnd("Season Mall, Magarpatta City", endCoordinates, "2021-08-11 09:00:10");
    ManageTrip manageTrip = CommonHelpers.createBodyForManageTripApi(null, 36, start, end, "Goa Trip",0, 0, 0, null);

    @Test(groups = {"sanity", "regression"})
    public void manageTrip(){
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", accessToken).
                log().all().
                body(manageTrip).
                when().
                request("POST", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
