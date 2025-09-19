package com.framework.endpoints;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class WordPressEndpoint {

    private static final String BASE_API = "https://public-api.wordpress.com/rest/v1.1";
    private static final String ACCESS_TOKEN = "0lvgx9q!wNXekc0DTJ$QfJo*ti!MX!Ru^(((cLSt^3C*#g3H5@8KI3NHA@Dw^WTE";

    public static Response getUserInfo() {
        return given()
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .when()
                .get(BASE_API + "/me")
                .then()
                .extract().response();
    }

    public static Response getUserSites() {
        return given()
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .when()
                .get(BASE_API + "/me/sites")
                .then()
                .extract().response();
    }

    public static Response getSitePosts(String siteId) {
        return given()
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .when()
                .get(BASE_API + "/sites/" + siteId + "/posts")
                .then()
                .extract().response();
    }

    public static Response getPostById(String siteId, int postId) {
        return given()
                .header("Authorization", "Bearer " + ACCESS_TOKEN)
                .pathParam("postId", postId)
                .when()
                .get(BASE_API + "/sites/" + siteId + "/posts/{postId}")
                .then()
                .extract().response();
    }
}
