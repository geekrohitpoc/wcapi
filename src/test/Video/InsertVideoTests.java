package test.Video;

import main.java.helpers.*;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.annotations.Test;
import main.java.pojo.video.InsertVideo;

import static io.restassured.RestAssured.given;

public class InsertVideoTests extends EnvironmentHelper {
    public static final String ENDPOINT = "/api/record/insertVideo";
    InsertVideo insertVideo = CommonHelpers.createBodyForInsertVideo("sample_mp4_file.mp4","00:00:31", "https://easyupload.io/lhye0t", 24.12132, 65.3245, "Clover Street", 303, 36,4);

    @Test(groups = {"sanity", "regression"})
    public void insertVideo(){
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", accessToken).
                log().all().
                body(insertVideo).
                when().
                request("POST", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }


}
