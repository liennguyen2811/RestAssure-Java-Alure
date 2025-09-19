package com.framework.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OAuth2TokenFetcher {

    @Test(priority = 1)
    public void getToken(){
        String clientId = "124975";
        String clientSecret = "HSlrf7hJVRS00lJbA8gBvh9hkmPUVmKRChNYAwRp8dCgVYaXaQt7Ps4FNqMVSHcz";
        String redirectUri = "https://yourapp.com/callback";
        String authorizationCode = "niC13zzcw3"; // <-- mã bạn vừa nhận

        Response response = RestAssured
            .given()
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("client_id", clientId)
                .formParam("client_secret", clientSecret)
                .formParam("code", authorizationCode)
                .formParam("grant_type", "authorization_code")
                .formParam("redirect_uri", redirectUri)
            .when()
                .post("https://public-api.wordpress.com/oauth2/token")
            .then()
                .extract().response();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Access Token: " + response.jsonPath().getString("access_token"));
    }
}

