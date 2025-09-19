package com.framework.tests;

import com.framework.models.Post;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PostApiTest {

    @Test
    public void testCreateAndReadPost() {
        // Tạo object Java
        Post newPost = new Post(1, "Hello World", "This is a test post");

        // Gửi POST request (serialize object Java → JSON)
        Response postResponse = RestAssured.given()
                .contentType("application/json")
                .body(newPost)
                .post("https://jsonplaceholder.typicode.com/posts");

        postResponse.prettyPrint();

        // Deserialize JSON → object Java
        Post createdPost = postResponse.as(Post.class);

        System.out.println("Created Post:");
        System.out.println(createdPost);
    }

    @Test
    public  void testCreateAndReadPost2 (){
        String json = "{ \"userId\": 2, \"id\": 202, \"title\": \"Deserialize Demo\", \"body\": \"This post was created from JSON\" }";

        try {
            ObjectMapper mapper = new ObjectMapper();

            // Chuyển JSON thành object Java
            Post post = mapper.readValue(json, Post.class);

            // In ra object Java
            System.out.println("Deserialized Post:");
            System.out.println(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
