package test.Voice;

import main.java.helpers.EnvironmentHelper;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteVoiceTests extends EnvironmentHelper {

    public static final String ENDPOINT = "/api/record/deleteVoice/133";

    @Test(groups = {"sanity", "regression"}, enabled = false)
    public void deleteVoice(){
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", accessToken).
                log().all().
                when().
                request("DELETE", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
