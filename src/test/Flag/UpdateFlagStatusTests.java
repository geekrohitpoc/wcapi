package test.Flag;

import main.java.helpers.*;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.annotations.Test;
import main.java.pojo.flag.UpdateFlagStatus;

import static io.restassured.RestAssured.given;

public class UpdateFlagStatusTests extends EnvironmentHelper {
    public static final String ENDPOINT = "/api/flag/updateFlagStatus";
    UpdateFlagStatus updateFlagStatus = CommonHelpers.createBodyForUpdateFlagStatus(411, true, 36);

    @Test(groups = {"sanity", "regression"})
    public void updateFlagStatus(){
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", accessToken).
                log().all().
                body(updateFlagStatus).
                when().
                request("PUT", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }

}
