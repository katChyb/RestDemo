import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUsers extends TestBase {
    private static final String USERS = "/users";

    String body = """
{
    "name": "Mateusz Tadla",
    "username": "mtadla",
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
                        .put(BASE_URL + USERS + "/1").
                then()
                        .statusCode(200)
                        .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.get("id").toString(), "1");
        Assert.assertEquals(jsonPath.get("username"), "mtadla");
    }

    @Test
    public void shouldPatchUser() {
        Response response =
                given()
                        .body(body)
                        .contentType(ContentType.JSON).
                when()
                        .patch(BASE_URL + USERS + "/1").
                then()
                        .statusCode(200)
                        .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.get("id").toString(), "1");
        Assert.assertEquals(jsonPath.get("username"), "mtadla");
    }

    @Test
    public void shouldDeleteUser() {
        given()
                .body(body)
                .contentType(ContentType.JSON).
        when()
                .delete(BASE_URL + USERS + "/1").
        then()
                .statusCode(200);
    }
}

