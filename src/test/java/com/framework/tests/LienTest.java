package com.framework.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import com.framework.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class LienTest extends BaseTest {

    @Test
    public void testGetPostById() {

        System.out.println("Running testGetPostById...");
        Response response = RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/1");

        // Kiểm tra mã trạng thái
        assertEquals(response.getStatusCode(), 200);

        // Kiểm tra tiêu đề
        String title = response.jsonPath().getString("title");
        System.out.println("Title: " + title);
        assertEquals(title, "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
    }
}

