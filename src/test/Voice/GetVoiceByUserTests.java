package test.Voice;

import main.java.helpers.EnvironmentHelper;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetVoiceByUserTests extends EnvironmentHelper {

    public static final String ENDPOINT = "/api/record/getVoiceByUser/36";

    @Test(groups = {"sanity", "regression"})
    public void getVoiceByUser(){
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", accessToken).
                log().all().
                when().
                request("GET", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
