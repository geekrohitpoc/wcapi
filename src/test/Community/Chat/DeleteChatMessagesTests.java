package test.Community.Chat;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.UtilsHelpers;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class DeleteChatMessagesTests extends EnvironmentHelper {
    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanDeleteChatMessages() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("CommunityChatEndpoints.properties", "DELETE_CHAT_MESSAGES_ENDPOIINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                queryParam("post_id",1617).
                queryParam("id",126).
                log().ifValidationFails().
                when().
                request("DELETE", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
