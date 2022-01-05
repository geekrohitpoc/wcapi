package test.Profile;

import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import main.java.helpers.EnvironmentHelper;
import main.java.helpers.ProfileHelpers;
import main.java.helpers.UtilsHelpers;
import main.java.pojo.profile.EditComment;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class EditCommentEndpointTests extends EnvironmentHelper {
    EditComment editComment = ProfileHelpers.createBodyForEditComment("GoodWork");

    @Test(groups = {"sanity", "regression"})
    public void verifyThatUserCanDeleteComment() throws IOException {
        String ENDPOINT = UtilsHelpers.getProperties("ProfileEndpoints.properties", "EDIT_COMMENT_ENDPOINT");
        ResponseBodyExtractionOptions response = given().
                config(RestAssuredConfig.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false))).
                contentType("application/json").
                with().
                header("Authorization", ACCESS_TOKEN).
                body(editComment).
                log().all().
                when().
                request("PUT", ENDPOINT).
                then().
                log().all().
                statusCode(200).
                assertThat().
                extract().body();
    }
}
