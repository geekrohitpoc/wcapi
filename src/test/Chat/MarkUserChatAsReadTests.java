package test.Chat;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.ChatHelpers;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.chat.MarkUserChatAsRead;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class MarkUserChatAsReadTests extends EnvironmentHelper {
    MarkUserChatAsRead markUserChatAsRead = ChatHelpers.createBodyForMarkUserChatAsRead(4, 89, "Varun887", "ImranShaikh", 36);

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanMarkChatAsRead() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ChatEndpoints.properties", "MARK_USER_CHAT_AS_READ_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                body(markUserChatAsRead).
                when().
                request("PUT", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
