package test.Voice;

import main.java.helpers.*;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.annotations.Test;
import main.java.pojo.voice.InsertVoice;

import static io.restassured.RestAssured.given;

public class InsertVoiceTests extends EnvironmentHelper {
    public static final String ENDPOINT = "/api/record/insertVoice";
    InsertVoice insertVoice = CommonHelpers.createBodyForInsertVoice("sample_mpg_file.mpg","00:01:22", "https://easyupload.io/76tr55", 24.12132, 65.3245, "Clover Street", 303, 36,4);

    @Test(groups = {"sanity", "regression"})
    public void insertVoice(){
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", accessToken).
                log().all().
                body(insertVoice).
                when().
                request("POST", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
