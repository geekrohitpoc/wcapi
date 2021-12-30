package main.java.helpers;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class EnvironmentHelper {
    public static String ENV = ((System.getProperty("ENV")==null || System.getProperty("ENV").isEmpty()) ? "wcapi.techechelons.net" : System.getProperty("ENV"));
    public static String ACCESS_TOKEN = System.getProperty("ACCESS_TOKEN");


    @BeforeTest(groups = {"sanity", "regression"})
    public void setUpBasePaths() {
        System.out.println("Setting up base paths as :" + ENV);
        RestAssured.baseURI = ENV;
        ACCESS_TOKEN = "Bearer eyJraWQiOiJGWEphelZCeHVzSVZMc09BUnpLdndiTzYyOUdYWHN6NnpmN0ZOOFlKMHpnPSIsImFsZyI6IlJTMjU2In0.eyJvcmlnaW5fanRpIjoiNGQwMWZjMTktZjI3Yi00M2I0LWJlYzQtZGRiOWQ1ZDhjMWI5Iiwic3ViIjoiZmM1YzA5YmUtMjA4Ni00NDg3LWE0ZjYtNGJjYTY3MDExYWNmIiwiZXZlbnRfaWQiOiJlYzMxZmE1Yy0zMzVlLTQ3M2ItODI0Zi1mNGQ1MDdkN2FkMTgiLCJ0b2tlbl91c2UiOiJhY2Nlc3MiLCJzY29wZSI6ImF3cy5jb2duaXRvLnNpZ25pbi51c2VyLmFkbWluIiwiYXV0aF90aW1lIjoxNjM1NzU5OTk4LCJpc3MiOiJodHRwczpcL1wvY29nbml0by1pZHAuYXAtc291dGgtMS5hbWF6b25hd3MuY29tXC9hcC1zb3V0aC0xX1pwWjc0dWhSWSIsImV4cCI6MTYzNTg0NjM5OCwiaWF0IjoxNjM1NzU5OTk4LCJqdGkiOiI2OGZiM2E1MS1lZmIzLTQ0NjUtYTZiMS0yYjVlYjMyODdjNzQiLCJjbGllbnRfaWQiOiI0c2s0aW1jNXNqN25zczEydDFobDU4MWtjdiIsInVzZXJuYW1lIjoiMDg0MzBjMGQtZTJjNS00Njg1LWJiNDUtNTRlMjRlYjg4YTYwIn0.XMPAzWEFqcCZk9V50BOrnMxGsZ24TftdENLnaSXUOMIGa6dhyP8cgerpyI14jy_kEm5vNEOeIvhhxXUsC7DVrsWGo0-SVXew1rJ-wi1owZJSUkGxG6KNQyH62pjIsbvaxNXuSCmYb2As35C60fk66v7wFeX6e1HZvgyGRcH1TtQg_0x8rkMdC6PhlxuGZ2XbET5ZAa9E1cnE5nLtfcA9i_RIJI_VCxuJ2sLVTonVZ9yRSIJLE2GkLS0w-VLUB9C6sGKoPrWAXNTMVLhcuNFDxck46hZ0GXZoCfpIsLNjK5KweBmj7CigvQ5YNAJ_voZklj3jgf-iH3dePo3RFGcHsQ";
    }
}
