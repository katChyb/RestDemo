package apiWeatherTest;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;

public class weatherForLocation {

    @Test
    @ParameterizedTest(name = "{0} has been verified")
    @MethodSource("general.DataProviderWeatherTest#testDataLocations")
    public void shouldGETweatherForGivenLocation(String location) {
        RequestSpecification specification = given()
                .param("q", location)
                .param("appid", "b1b15e88fa797225412429c1c50c122a1")
                .log()
                .all();


        ResponseSpecification responseSpecification = RestAssured.expect();
        responseSpecification.log().all();
        responseSpecification.statusCode(200);

        given()
                .spec(specification)
                .when()
                .get("https://samples.openweathermap.org/data/2.5/weather")
                .then()
                .spec(responseSpecification);
    }


    @Test
    public void shouldGETweatherforLondonReqSpecification() {
        RequestSpecification specification = given()
                .param("q", "London,uk")
                .param("appid", "b1b15e88fa797225412429c1c50c122a1")
                .log()
                .all();
        given()
                .spec(specification)
                .when()
                .get("https://samples.openweathermap.org/data/2.5/weather")
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}


