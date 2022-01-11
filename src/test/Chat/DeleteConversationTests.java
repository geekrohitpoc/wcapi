package test.Chat;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.ChatHelpers;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.chat.DeleteConversation;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class DeleteConversationTests extends EnvironmentHelper {
    DeleteConversation deleteConversation = ChatHelpers.createBodyForDeleteConversation(4, 36);

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanDeleteConversation() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ChatEndpoints.properties", "DELETE_CONVERSATION_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                body(deleteConversation).
                when().
                request("DELETE", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
