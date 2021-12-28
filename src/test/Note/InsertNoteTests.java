package test.Note;

import main.java.helpers.*;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.annotations.Test;
import main.java.pojo.note.InsertNote;

import static io.restassured.RestAssured.given;

public class InsertNoteTests extends EnvironmentHelper {

    public static final String ENDPOINT = "/api/record/insertNote";
    InsertNote insertNote = CommonHelpers.createBodyForInsertNote("Yash Snacks", 24.12132, 65.3245, "Clover Street", 303, 36,4);

    @Test(groups = {"sanity", "regression"})
    public void insertImage(){
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", accessToken).
                log().all().
                body(insertNote).
                when().
                request("POST", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
