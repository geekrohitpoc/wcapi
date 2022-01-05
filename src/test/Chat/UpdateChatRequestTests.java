package test.Chat;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.ChatHelpers;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.chat.UpdateChatRequest;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class UpdateChatRequestTests extends EnvironmentHelper {
    UpdateChatRequest updateChatRequest = ChatHelpers.createBodyForUpdateChatRequest(4, 89, "Varun887", "ImranShaikh", 36,1);

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanUpdateChatRequest() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ChatEndpoints.properties", "UPDATE_CHAT_REQUEST_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().all().
                body(updateChatRequest).
                when().
                request("PUT", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
