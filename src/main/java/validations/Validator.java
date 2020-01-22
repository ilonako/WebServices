package validations;

import io.restassured.response.Response;
import models.StatusCodeType;

import static org.assertj.core.api.Assertions.assertThat;

public class Validator {

    public Validator validateStatusCode(StatusCodeType type, Response response) {
        assertThat(type.getType()).isEqualTo(response.getStatusCode());
        return this;
    }
}
