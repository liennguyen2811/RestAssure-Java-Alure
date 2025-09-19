package com.framework.tests;

import com.framework.endpoints.WordPressEndpoint;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WordPressUserTest {

    @Test
    public void testGetUserInfo() {
        Response response = WordPressEndpoint.getUserInfo();
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        Assert.assertTrue(response.jsonPath().getString("username") != null, "Username should not be null");
    }

}
