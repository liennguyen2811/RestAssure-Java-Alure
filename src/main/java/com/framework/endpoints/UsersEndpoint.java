package com.framework.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UsersEndpoint {

    private static final String USERS_PATH = "/users";

    public static Response getAllUsers() {
        return given()
                .when()
                .get(USERS_PATH)
                .then()
                .extract().response();
    }

    public static Response getUserById(int id) {
        return given()
                .pathParam("id", id)
                .when()
                .get(USERS_PATH + "/{id}")
                .then()
                .extract().response();
    }
}
