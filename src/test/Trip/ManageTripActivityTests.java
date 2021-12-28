package test.Trip;

import main.java.helpers.*;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.annotations.Test;
import main.java.pojo.trip.*;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class ManageTripActivityTests extends EnvironmentHelper {

    public static final String ENDPOINT = "/api/record/manageTripActivity";
    ArrayList<Analytics> analyticsList = new ArrayList<>();
    ArrayList<RouteRecord> routeRecordsList = new ArrayList<>();
    ArrayList<PausedResume> pausedResumeList = new ArrayList<>();
    Coordinates startCoordinates = CommonHelpers.createBodyForCoordinates(18.519627479345335, 73.93235133787392);
    Coordinates endCoordinates = CommonHelpers.createBodyForCoordinates(18.519627479345335,73.93235133787392);
    Coordinates pausedLocationCoordinates = CommonHelpers.createBodyForCoordinates(18.567962747934533, 73.68623513378739);
    Start start = CommonHelpers.createBodyForStart("Season Mall, Magarpatta City", startCoordinates, "2021-08-05 10:12:58");
    End end = CommonHelpers.createBodyForEnd("Sinhgad Road,Sinhgad", endCoordinates, "2021-08-11 09:00:10");
    RouteRecord routeRecord = CommonHelpers.createBodyForRouteRecord(18.519627479345335, 73.93235133787392);
    Analytics analytics = CommonHelpers.createBodyForAnalytics(45,"00:00:50", 100, 200);
    PausedLocation pausedLocation = CommonHelpers.createBodyForPausedLocation("Tamhini Ghat", pausedLocationCoordinates);
    PausedResume pausedResume = CommonHelpers.createBodyForPausedResume("2021-08-05 10:12:58", "2021-08-06 09:50:00", pausedLocation);

    @Test(groups = {"sanity", "regression"})
    public void manageTripActivity(){
        analyticsList.add(analytics);
        routeRecordsList.add(routeRecord);
        pausedResumeList.add(pausedResume);
        ManageTripActivity manageTripActivity = CommonHelpers.createBodyForManageTripActivity(303,36, null,12, "Surfing", 0, pausedResumeList,analyticsList, routeRecordsList, start, end);

        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", accessToken).
                log().all().
                body(manageTripActivity).
                when().
                request("POST", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
