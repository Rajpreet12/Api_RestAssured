package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpoint.userendpoints;
import io.restassured.response.Response;
import payload.userpojo;

public class Usertest {
    Faker faker;
    userpojo userPayload;
    String token;
    String owner = "Rajpreet12";
    String repo = "test-repo";

    @BeforeClass
    public void setupData() {
        faker = new Faker();
        userPayload = new userpojo();
        userPayload.setName(repo);
        userPayload.setDescription(faker.lorem().sentence());
        userPayload.setPrivateRepo(false);
        token = System.getenv("GITHUB_TOKEN"); // Fetching token from environment variable
    }

    @Test(priority = 1)
    public void testCreateUser() {
        Response response = userendpoints.CreateUser(userPayload, token);
        response.then().statusCode(201);
        System.out.println("Create User Response: " + response.body().asString());
    }

    @Test(priority = 2)
    public void testReadUser() {
        Response response = userendpoints.readUser(owner, repo);
        response.then().statusCode(200);
        System.out.println("Read User Response: " + response.body().asString());
    }

    @Test(priority = 3)
    public void testUpdateUser() {
        userPayload.setDescription("Updated description");
        Response response = userendpoints.updateUser(owner, repo, userPayload, token);
        response.then().statusCode(200);
        System.out.println("Update User Response: " + response.body().asString());
    }

    @Test(priority = 4)
    public void testDeleteUser() {
        Response response = userendpoints.deleteUser(owner, repo, token);
        response.then().statusCode(204);
        System.out.println("Delete User Response: " + response.body().asString());
    }
}
