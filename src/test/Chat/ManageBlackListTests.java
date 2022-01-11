package test.Chat;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.ChatHelpers;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.chat.ManageBlackList;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ManageBlackListTests extends EnvironmentHelper {
    ManageBlackList manageBlackList = ChatHelpers.createBodyForManageBlackList(36, 104, true);

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanManageBlackLists() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ChatEndpoints.properties", "MANAGE_BLACKLIST_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                body(manageBlackList).
                when().
                request("POST", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
