package test.Flag;

import main.java.helpers.*;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.pojo.flag.GetPublicFlagByCoordinate;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetFlagByCoordinatesTests extends EnvironmentHelper {
    public static final String ENDPOINT = "/api/flag/getPublicFlagByCoordinates";
    GetPublicFlagByCoordinate getPublicFlagByCoordinate = CommonHelpers.createBodyForGetPublicFlagByCoordinates(18.5196, 73.8411, 36);

    @Test(groups = {"sanity", "regression"})
    public void getPublicFlagByCoordinates(){
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", accessToken).
                log().all().
                body(getPublicFlagByCoordinate).
                when().
                request("POST", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
