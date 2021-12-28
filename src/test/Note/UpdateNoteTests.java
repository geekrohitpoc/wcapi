package test.Note;

import main.java.helpers.*;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.annotations.Test;
import main.java.pojo.note.UpdateNote;

import static io.restassured.RestAssured.given;

public class UpdateNoteTests extends EnvironmentHelper {

    public static final String ENDPOINT = "/api/record/updateNote";
    UpdateNote updateNote = CommonHelpers.createBodyForUpdateNote("Yash Snacks", 4);

    @Test(groups = {"sanity", "regression"})
    public void updateNote(){
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", accessToken).
                log().all().
                body(updateNote).
                when().
                request("PUT", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }

}
