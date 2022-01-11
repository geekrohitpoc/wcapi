package test.Chat;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.ChatHelpers;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.chat.GetChatRequestsList;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetChatRequestListTests extends EnvironmentHelper {
    GetChatRequestsList getChatRequestsList = ChatHelpers.createBodyForGetChatRequestsList(90);

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanGetChatRequestList() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ChatEndpoints.properties", "GET_CHAT_REQUEST_LIST_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                body(getChatRequestsList).
                when().
                request("POST", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
