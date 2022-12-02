import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetUsers extends TestBase {

    private static final String USERS = "/users";

    @Test
    public void shouldGetAllUsers() {
        when()
                .get(BASE_URL + USERS).
                then()
                .statusCode(200);
    }

    @Test
    public void shouldGetFistUser() {
        when()
                .get(BASE_URL + USERS + "/1").
                then()
                .statusCode(200);
    }

    @Test
    public void shouldGetFistUserWithPathVariable() {
        given()
                .pathParam("id", "1").
                when()
                .get(BASE_URL + USERS + "/{id}").
                then()
                .statusCode(200);
    }

    @Test
    public void shouldGetUserWithQueryParam() {
        Response response =
                given()
                    .queryParam("username", "Bret").
                when()
                    .get(BASE_URL + USERS + "/1").
                then()
                    .statusCode(200).extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.get("username"), "Bret");
        Assert.assertEquals(jsonPath.get("address.geo.lat"), "-37.3159");
    }
}
