import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUsers extends TestBase {
    private static final String USERS = "/users";

    String body = """
{
    "name": "Mateusz Tadla",
    "username": "mtadla",
    "email": "Sincere@april.biz",
    "address": {
        "street": "Kulas Light",
        "suite": "Apt. 556",
        "city": "Gwenborough",
        "zipcode": "92998-3874",
        "geo": {
            "lat": "-37.3159",
            "lng": "81.1496"
        }
    },
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "company": {
        "name": "Romaguera-Crona",
        "catchPhrase": "Multi-layered client-server neural-net",
        "bs": "harness real-time e-markets"
    }
}
""";

    @Test
    public void shouldPostUser() {
        Response response =
                given()
                        .body(body)
                        .contentType(ContentType.JSON).
                when()
                        .post(BASE_URL + USERS).
                then()
                        .statusCode(201)
                        .extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(jsonPath.get("username"), "mtadla");
    }
}
