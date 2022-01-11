package test.Community.Group;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.GroupHelpers;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.community.group.CreateGroup;
import main.java.pojo.community.group.Fields;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class CreateGroupTests extends EnvironmentHelper {

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanCreateCommunityGroup() throws IOException {
        ArrayList<Integer> categories = new ArrayList<>();
        categories.add(6);
        Fields fields = GroupHelpers.createBodyForFields("", "Mumbai","this is what to expect","open","members","topic");
        CreateGroup createGroup = GroupHelpers.createBodyForCommunityCreateGroup("publish","Mumbai Cycling Brothers","This is a cycling group",categories, fields);

        String ENDPOINT = UtilsHelpers.getProperties("GroupEndpoints.properties", "COMMUNITY_CREATE_GROUP_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                body(createGroup).
                when().
                request("POST", ENDPOINT).
                then().
                log().all().
                statusCode(201).
                assertThat().
                extract().body();
    }

}
