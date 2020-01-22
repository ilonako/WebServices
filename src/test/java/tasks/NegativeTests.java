package tasks;

import io.restassured.response.Response;
import utils.StatusCodeType;
import org.testng.annotations.Test;

public class NegativeTests extends BaseTest {

    @Test
    public void postInvalidUserData() {
        Response post = client.post(jsonObjects.serializeInvalidObject());
        validator.validateStatusCode(StatusCodeType.CREATED, post);
    }
}
