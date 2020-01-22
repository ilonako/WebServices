package client;

import static io.restassured.RestAssured.*;

import endpoints.EndPoint;
import io.restassured.response.Response;


public class RestClient extends EndPoint {

    private Response response;

    public Response post(Object body) {
        response = given().body(body)
                .log().all()
                .when().post(baseURI)
                .then().log().all()
                .extract().response();
        return response;
    }

    public Response get(int userId) {
        response = given().pathParams("id", userId)
                .get(userEndPoint)
                .then().log().all()
                .extract().response();
        return response;
    }

    public Response put(Object body, int userId) {
        response = given().pathParams("id", userId)
                .body(body).log().all()
                .when().put(userEndPoint)
                .then().log().all()
                .extract().response();
        return response;
    }

    public Response patch(Object body, int userId) {
        response = given().pathParams("id", userId)
                .body(body).log().all()
                .when().patch(userEndPoint)
                .then().log().all()
                .extract().response();
        return response;
    }

    public Response delete(int userId) {
        response = given().pathParams("id", userId)
                .delete(userEndPoint)
                .then().log().all()
                .extract().response();
        return response;
    }
}
