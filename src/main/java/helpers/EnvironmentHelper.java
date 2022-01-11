package main.java.helpers;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class EnvironmentHelper {
    public static String ENV = ((System.getProperty("ENV")==null || System.getProperty("ENV").isEmpty()) ? "http://wc.techechelons.net" : System.getProperty("ENV"));
    public static String ACCESS_TOKEN = System.getProperty("ACCESS_TOKEN");

    @BeforeSuite(groups = {"sanity", "regression"})
    public void setUpBasePaths() {
        System.out.println("Setting up base paths as :" + ENV);
        RestAssured.baseURI = ENV;
        ACCESS_TOKEN = "Bearer eyJraWQiOiJGWEphelZCeHVzSVZMc09BUnpLdndiTzYyOUdYWHN6NnpmN0ZOOFlKMHpnPSIsImFsZyI6IlJTMjU2In0.eyJvcmlnaW5fanRpIjoiNjYxOGQxZDYtNGU0Ny00NzRiLWE0YzYtYWM0MjkxZjkyMjhiIiwic3ViIjoiNmE4YmZhNjYtMjYwNS00M2Q5LWFjMmYtZjFiMWU0MGY2NzA1IiwiZXZlbnRfaWQiOiJlOGI3NzZlNS1jMzg4LTQ3M2EtYTJiYS0xMjBiMzQyZDAzOTciLCJ0b2tlbl91c2UiOiJhY2Nlc3MiLCJzY29wZSI6ImF3cy5jb2duaXRvLnNpZ25pbi51c2VyLmFkbWluIiwiYXV0aF90aW1lIjoxNjQxODc4ODczLCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAuYXAtc291dGgtMS5hbWF6b25hd3MuY29tXC9hcC1zb3V0aC0xX1pwWjc0dWhSWSIsImV4cCI6MTY0MTk2NTI3MywiaWF0IjoxNjQxODc4ODczLCJqdGkiOiIxNWVmYjZkNi03ZjAwLTRhNTQtYjlhZS1iNjg5YTllYjc4N2QiLCJjbGllbnRfaWQiOiI0czJnYzBzYWFsbDFpYmV1Y2Fib2sxazMyOCIsInVzZXJuYW1lIjoiZDQ5OTBiN2YtYzlmOS00MDQ1LWFlNGItZDY5YTBiYWUxN2ExIn0.gciciE6zH-mj6f5-mbrdDWODpiYwf75MKz4ezCjT8hA_NU3CrF8ka59qAW1F-HoD9qA6E5zbQotPngw4-SyAqYVy7b-izo7YYVbchBYKdDDF7IgvLhL2M0IY_3wofBVH7WuhaaLgiicFlKfY06jYPag36zmzC_0ZuunMWHnqaqyYkKKONWfuNuIbRMclq4_GN6QYQsHcyymhshstE3HQNPzAgU6IvK1HmD-sUt3tmjMTFNDSSPOof6_ie4EzXN0YC75fPQQWWA41tCJ9gbHLdjPs26_jt7MSY23_cBkyq74JaVo8w_tVrnIUlnQFOMvQj6lJpS0l84V8WonAnqEK_A";
    }

}
