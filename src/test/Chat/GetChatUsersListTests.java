package test.Chat;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.CommonHelpers;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.chat.GetChatUsersList;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetChatUsersListTests extends EnvironmentHelper {
    GetChatUsersList getChatUsersList = CommonHelpers.createBodyForGetChatUsersList(36);

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCangetChatUsersList() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ChatEndpoints.properties", "GET_CHAT_USER_LIST_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().all().
                body(getChatUsersList).
                when().
                request("POST", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}