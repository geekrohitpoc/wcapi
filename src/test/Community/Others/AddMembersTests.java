package test.Community.Others;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.MemberHelpers;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.community.members.AddMembers;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class AddMembersTests extends EnvironmentHelper {

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanAddMembers() throws IOException {
        ArrayList<Integer> userIds = new ArrayList<>();
        userIds.add(46);
        userIds.add(104);
        userIds.add(36);
        userIds.add(71);
        userIds.add(121);
        AddMembers addMembers = MemberHelpers.createBodyForAddMembers(1757,userIds);
        String ENDPOINT = UtilsHelpers.getProperties("CommunityEndpoints.properties", "ADD_MEMBERS_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                log().ifValidationFails().
                when().
                body(addMembers).
                request("POST", ENDPOINT).
                then().
                log().ifValidationFails().
                statusCode(200).
                assertThat().
                extract().body();
    }

}
