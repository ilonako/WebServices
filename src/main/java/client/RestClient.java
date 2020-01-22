package client;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import utils.EndPointConstants;


public class RestClient {

    private Response response;

    public Response post(Object body) {
        response = given().body(body)
                .when().post(EndPointConstants.BASE_URI)
                .then().log().all()
                .extract().response();
        return response;
    }

    public Response get(int userId) {
        response = given().pathParams("id", userId)
                .get(EndPointConstants.USER_ID)
                .then().log().all()
                .extract().response();
        return response;
    }

    public Response put(Object body, int userId) {
        response = given().pathParams("id", userId)
                .body(body)
                .when().put(EndPointConstants.USER_ID)
                .then().log().all()
                .extract().response();
        return response;
    }

    public Response patch(Object body, int userId) {
        response = given().pathParams("id", userId)
                .body(body)
                .when().patch(EndPointConstants.USER_ID)
                .then().log().all()
                .extract().response();
        return response;
    }

    public Response delete(int userId) {
        response = given().pathParams("id", userId)
                .delete(EndPointConstants.USER_ID)
                .then()
                .log().all()
                .extract().response();
        return response;
    }
}
