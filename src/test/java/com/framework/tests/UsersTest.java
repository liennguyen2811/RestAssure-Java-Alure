package com.framework.tests;

import com.framework.base.BaseTest;
import com.framework.endpoints.UsersEndpoint;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UsersTest extends BaseTest {

    @Test(priority = 1)
    public void testGetAllUsers() {
        logInfo("Starting test: Get all users");

        Response response = UsersEndpoint.getAllUsers();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        Assert.assertTrue(response.jsonPath().getList("$").size() > 0, "Response should contain users");

        logPass("Get all users test passed");
    }

    @Test(priority = 2)
    public void testGetUserById() {
        logInfo("Starting test: Get user by ID");

        int userId = 1;
        Response response = UsersEndpoint.getUserById(userId);

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");
        Assert.assertEquals(response.jsonPath().getInt("id"), userId, "User ID should match");
        Assert.assertNotNull(response.jsonPath().getString("name"), "Name should not be null");
        Assert.assertNotNull(response.jsonPath().getString("email"), "Email should not be null");

        logPass("Get user by ID test passed");
    }
}
