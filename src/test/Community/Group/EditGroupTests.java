package test.Community.Group;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.GroupHelpers;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.community.group.CreateGroup;
import main.java.pojo.community.group.EditGroup;
import main.java.pojo.community.group.Fields;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class EditGroupTests extends EnvironmentHelper {

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanEditCommunityGroup() throws IOException {
        ArrayList<Integer> categories = new ArrayList<>();
        categories.add(6);
        Fields fields = GroupHelpers.createBodyForFields("", "Pune","this is what to expect","open","members","topic");
        EditGroup editGroup = GroupHelpers.createBodyForCommunityEditGroup("publish","Mumbai Cycling Brothers","This is a cycling group",categories, fields);

        String ENDPOINT = UtilsHelpers.getProperties("GroupEndpoints.properties", "EDIT_GROUP_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().all().
                body(editGroup).
                when().
                request("POST", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
