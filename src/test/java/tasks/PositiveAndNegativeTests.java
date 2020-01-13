package tasks;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PositiveAndNegativeTests {

    private static String payload = "{\n" +
            "  \"first_name\": \"morpheus\",\n" +
            "  \"job\": \"zion resident\",\n" +
            "}";

    @Test(priority = 1)
    public void getSimpleResponse() {
        given()
                .get("https://reqres.in/api/users?page=2").
        then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 2)
    public void postSimpleUser() {
        baseURI = "https://reqres.in/api/users";

        given()
                .param("name", "morpheus")
                .param("job", "leader").
        then()
                .body("name", equalTo("morpheus"))
                .statusCode(201);
    }

    @Test(priority = 3)
    public void putTheUser() {
        baseURI = "https://reqres.in/api/users/2";

        given()
                .param("name", "morpheus")
                .param("job", "zion resident").
        then()
                .body("name", equalTo("zion resident"))
                .statusCode(200);
    }

    @Test(priority = 4)
    public void deleteTheUser() {
        given()
                .delete("https://reqres.in/api/users/2").
        then()
                .statusCode(204);
    }

    @Test(priority = 5)
    public void postLogin() {
        baseURI = "https://reqres.in/api/login";

        given()
                .param("email", "eve.holt@reqres.in")
                .param("password", "cityslicka").
        then()
                .statusCode(201);
    }

    @Test(priority = 6)
    public void postInvalidLogin() {
        baseURI = "https://reqres.in/api/register";

        given()
                .param("email", "ydney@fife").
        then()
                .statusCode(400);
    }

    @Test(priority = 7)
    public void getNotFoundPage() {
        given()
                .get("https://datafeed-api.dynatrace.com/").
        then()
                .statusCode(404);
    }

    @Test(priority = 8)
    public void postInvalidParams() {
        baseURI = "https://reqres.in/api/users";

        given()
                .param("first_name", "morpheus")
                .param("job_title", "zion resident").
        then()
                .statusCode(400);
    }

    @Test(priority = 9)
    public void putInvalidParams() {
        baseURI = "https://reqres.in/api/users/3";

        given()
                .body(payload).
        then()
                .statusCode(400);
    }

    @Test(priority = 10)
    public void deleteInvalidUser() {
        baseURI = "http://www.appdomain.com/users/123/accounts";

        given()
                .delete(baseURI + "/456").
        then()
                .statusCode(405)
                .log().status();
    }
}
