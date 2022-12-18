package general;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    @BeforeAll
    public static void setup(){
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}