package tasks;

import client.RestClient;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import utils.ParseJsonObjects;
import validations.Validator;

public class BaseTest {

    RestClient client = new RestClient();
    Validator validator = new Validator();
    ParseJsonObjects jsonObjects = new ParseJsonObjects();

    final int userId = 3;

    @BeforeClass
    public RequestSpecification setRequestSpecification() {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        return RestAssured.requestSpecification = requestSpec;
    }

}
