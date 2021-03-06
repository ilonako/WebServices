package tasks;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static utils.StatusCodeType.*;

public class PositiveTests extends BaseTest{

    @Test
    public void postSimpleUser() {
        Response post = client.post(jsonObjects.serializeListObjects());
        validator.validateStatusCode(CREATED, post);
    }

    @Test
    public void getSimpleUser() {
        Response get = client.get(userId);
        validator.validateStatusCode(OK, get);
    }

    @Test
    public void putUpdatesOnTheUser() {
        Response put = client.put(jsonObjects.serializeUpdatedObject(false), userId);
        validator.validateStatusCode(OK, put);
    }

    @Test
    public void patchUpdatesOnTheUser() {
        Response patch = client.patch(jsonObjects.serializeUpdatedObject(true), userId);
        validator.validateStatusCode(OK, patch);
    }

    @Test
    public void deleteSimpleUser() {
        Response delete = client.delete(userId);
        validator.validateStatusCode(NO_CONTENT, delete);
    }

}


























//    private static String payload = "{\n" +
//            "  \"first_name\": \"morpheus\",\n" +
//            "  \"job\": \"zion resident\",\n" +
//            "}";
//
//    private static String VALID_PAYLOAD = "{\n" +
//            "  \"first_name\": \"morpheus\",\n" +
//            "  \"job\": \"jkhk\"" +
//            "}";
//
//
//    @Test(priority = 6)
//    public void postInvalidLogin() {
//        baseURI = "https://reqres.in/api/register";
//
//        given()
//                .param("email", "ydney@fife").
//        then()
//                .statusCode(400);
//    }
//
//    @Test(priority = 7)
//    public void getNotFoundPage() {
//        given()
//                .get("https://datafeed-api.dynatrace.com/").
//        then()
//                .statusCode(404);
//    }
//
//    @Test(priority = 8)
//    public void postInvalidParams() {
//        baseURI = "https://reqres.in/api/users";
//
//        given()
//                .param("first_name", "morpheus")
//                .param("job_title", "zion resident").
//        then()
//                .statusCode(400);
//    }
//
//    @Test(priority = 9)
//    public void putInvalidParams() {
//        baseURI = "https://reqres.in/api/users/3";
//
//        given()
//                .body(payload).
//        then()
//                .statusCode(400);
//    }
//
//    @Test(priority = 10)
//    public void deleteInvalidUser() {
//        baseURI = "http://www.appdomain.com/users/123/accounts";
//
//        given()
//                .delete(baseURI + "/456").
//        then()
//                .statusCode(405)
//                .log().status();
//    }
