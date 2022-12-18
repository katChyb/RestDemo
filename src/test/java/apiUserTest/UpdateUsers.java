package apiUserTest;

import general.TestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class UpdateUsers extends TestBase {
    private static final String USERS = "/users";

    String body = """
{
    "name": "Kat Chy",
    "username": "katchy",
    "email": "Sincere@april.biz"
}
""";

    @Test
    public void shouldPutUser() {
        Response response =
                given()
                        .body(body)
                        .contentType(ContentType.JSON).
                when()
                        .put(TestBase.BASE_URL + USERS + "/1").
                then()
                        .statusCode(200)
                        .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.get("id").toString(), "1");
        Assert.assertEquals(jsonPath.get("username"), "katchy");
    }

    @Test
    public void shouldPatchUser() {
        Response response =
                given()
                        .body(body)
                        .contentType(ContentType.JSON).
                when()
                        .patch(TestBase.BASE_URL + USERS + "/1").
                then()
                        .statusCode(200)
                        .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.get("id").toString(), "1");
        Assert.assertEquals(jsonPath.get("username"), "katchy");
    }

    @Test
    public void shouldDeleteUser() {
        given()
                .body(body)
                .contentType(ContentType.JSON).
        when()
                .delete(TestBase.BASE_URL + USERS + "/1").
        then()
                .statusCode(200);
    }
}

