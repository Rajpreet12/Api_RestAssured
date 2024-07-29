package endpoint;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.userpojo;

public class userendpoints {
    public static Response CreateUser(userpojo payload, String token) {
        Response response = given()
            .header("Authorization", "token " + token)
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)
            .when()
            .post(RoutesURL.post_url);
        return response;
    }

    public static Response readUser(String owner, String repo) {
        Response response = given()
            .pathParam("owner", owner)
            .pathParam("repo", repo)
            .when()
            .get(RoutesURL.get_url);
        return response;
    }

    public static Response updateUser(String owner, String repo, userpojo payload, String token) {
        Response response = given()
            .header("Authorization", "token " + token)
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .pathParam("owner", owner)
            .pathParam("repo", repo)
            .body(payload)
            .when()
            .patch(RoutesURL.update_url);
        return response;
    }

    public static Response deleteUser(String owner, String repo, String token) {
        Response response = given()
            .header("Authorization", "token " + token)
            .pathParam("owner", owner)
            .pathParam("repo", repo)
            .when()
            .delete(RoutesURL.delete_url);
        return response;
    }
}
