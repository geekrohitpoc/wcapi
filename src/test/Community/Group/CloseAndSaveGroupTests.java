package test.Community.Group;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.GroupHelpers;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.community.group.CloseAndSaveGroup;
import main.java.pojo.community.group.CloseAndSaveGroupFields;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CloseAndSaveGroupTests extends EnvironmentHelper {

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanCloseAndSaveGroup() throws IOException {
        CloseAndSaveGroupFields closeAndSaveGroupFields = GroupHelpers.createBodyForCloseAndSaveGroupFields(false);
        CloseAndSaveGroup closeAndSaveGroup = GroupHelpers.createBodyForCloseAndSaveGroup(closeAndSaveGroupFields);
        String ENDPOINT = UtilsHelpers.getProperties("GroupEndpoints.properties", "CLOSE_GROUP_AND_SAVE_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().all().
                when().
                body(closeAndSaveGroup).
                request("PUT", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();
    }

}
