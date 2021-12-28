package test.Flag;

import main.java.helpers.*;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.pojo.flag.AddFlag;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddFlagTests extends EnvironmentHelper {

    public static final String ENDPOINT = "/api/flag/addFlag";
    AddFlag addFlag = CommonHelpers.createBodyForAddFlag("Mukesh Sutta and Snack Point", 24.12132, 65.3245, true, 303, 4,36);

    @Test(groups = {"sanity", "regression"})
    public void addFlag(){
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", accessToken).
                log().all().
                body(addFlag).
                when().
                request("POST", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
