package test.Community.Group;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.GroupHelpers;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.community.group.ChangeVisibilityOfGroup;
import main.java.pojo.community.group.VisibilityRuleField;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ChangeVisibilityOfGroupTests extends EnvironmentHelper {

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanChangeVisibilityOfGroups() throws IOException {
        VisibilityRuleField visibilityRuleField = GroupHelpers.createBodyForVisibilityRule("close");
        ChangeVisibilityOfGroup changeVisibilityOfGroup = GroupHelpers.createBodyForChangeVisibilityofGroup(visibilityRuleField);

        String ENDPOINT = UtilsHelpers.getProperties("GroupEndpoints.properties", "CHANGE_VISIBILITY_OF_GROUP_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().all().
                body(changeVisibilityOfGroup).
                when().
                request("POST", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
