package com.sharifyy;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

//    @Test
//    public void testHelloEndpoint() {
//        given()
//          .when().get("/frameworks")
//          .then()
//             .statusCode(200);
////             .body(is("Hello RESTEasy"));
//    }

}