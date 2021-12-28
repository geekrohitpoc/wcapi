package test.Image;

import main.java.helpers.*;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.annotations.Test;
import main.java.pojo.image.InsertImage;

import static io.restassured.RestAssured.given;

public class InsertImageTests extends EnvironmentHelper {
    public static final String ENDPOINT = "/api/record/insertImage";
    InsertImage insertImage = CommonHelpers.createBodyForInsertImage("https://ibb.co/yhfZLk3", 24.12132, 65.3245, "Clover Street", 303, 36,4);

    @Test(groups = {"sanity", "regression"})
    public void insertImage(){
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", accessToken).
                log().all().
                body(insertImage).
                when().
                request("POST", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
