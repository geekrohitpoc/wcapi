package test.Chat;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.ChatHelpers;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.chat.AddMessage;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class AddMessageTests extends EnvironmentHelper {
    AddMessage addMessage = ChatHelpers.createBodyForAddMessage("Hi, How are you?", 2, 4, 0, 89, "Varun887", "ImranShaikh", 36, "s3://imageURL.com", 0);

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanAddMessage() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ChatEndpoints.properties", "ADD_MESSAGE_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().all().
                body(addMessage).
                when().
                request("POST", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
