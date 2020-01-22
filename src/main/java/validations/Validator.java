package validations;

import io.restassured.response.Response;
import utils.StatusCodeType;

import static org.assertj.core.api.Assertions.assertThat;

public class Validator {

    public Validator validateStatusCode(StatusCodeType type, Response response) {
        assertThat(type.getType()).as("Status Code")
                .withFailMessage("%nExpected result: %d%nActual result: %d", type.getType(), response.getStatusCode())
                .isEqualTo(response.getStatusCode());
        return this;
    }
}
