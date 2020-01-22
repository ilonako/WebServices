package models;

public enum StatusCodeType {

    OK("200"),
    CREATED("201"),
    NO_CONTENT("204"),
    BAD_REQUEST("400"),
    UNAUTHORIZED("401"),
    FORBIDDEN("403"),
    NOT_FOUND("404");

    private String type;

    StatusCodeType(String type) {
        this.type = type;
    }

    public Integer getType() {
        return Integer.valueOf(type);
    }

}
