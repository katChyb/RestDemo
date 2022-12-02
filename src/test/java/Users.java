import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Users extends TestBase {

    @Test
    public void shouldGetAllUsers() {
        when()
                .get("https://jsonplaceholder.typicode.com/users").
                then()
                .statusCode(200);
    }

    @Test
    public void shouldGetFistUser() {
        when()
                .get("https://jsonplaceholder.typicode.com/users/1").
                then()
                .statusCode(200);
    }

    @Test
    public void shouldGetFistUserWithPathVariable() {
        given()
                .pathParam("id", "1").
                when()
                .get("https://jsonplaceholder.typicode.com/users/{id}").
                then()
                .statusCode(200);
    }

    @Test
    public void shouldGetUserWithQueryParam() {
        Response response =
                given()
                    .queryParam("username", "Bret").
                when()
                    .get("https://jsonplaceholder.typicode.com/users/1").
                then()
                    .statusCode(200).extract().response();

        JsonPath jsonPath = response.jsonPath();
        response.body();

        Assert.assertEquals(jsonPath.get("username"), "Bret");
        Assert.assertEquals(jsonPath.get("address.geo.lat"), "-37.3159");
    }
}
