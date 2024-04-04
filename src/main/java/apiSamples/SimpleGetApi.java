package apiSamples;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import pojo.GetBookingIdsResponse;

import java.io.File;

public class SimpleGetApi {
    public static void main(String[] args) {

        //Given - precondition
        //When - action
        //Then - validation
        //And
        //Needed for request specification

        RequestSpecification requestSpecification = RestAssured.given();
        File schema = new File("src/test/resources/schema/getBookingSchema.json");
        ValidatableResponse validatableResponse = requestSpecification
                .accept(ContentType.JSON)
                .filter(new RequestLoggingFilter())
                .and().baseUri("https://restful-booker.herokuapp.com")
                .and().basePath("/booking")
                .when().get()
                .then().statusCode(200)
                .and().body("bookingid", Matchers.notNullValue())
                .and().body(JsonSchemaValidator.matchesJsonSchema(schema));

        GetBookingIdsResponse[] responsePojo = validatableResponse.extract().as(GetBookingIdsResponse[].class);

        System.out.println(responsePojo[1].getBookingId());

//        ValidatableResponse validatableResponse = response.then();
//        validatableResponse.statusCode(200);
//
//        response.prettyPrint();
//
//        //Best way to assert from your response before using it
//        validatableResponse.body("bookingid", Matchers.notNullValue());
//
//        //json schema validation
//        File schema = new File("src/test/resources/schema/getBookingSchema.json");
//        validatableResponse.body(JsonSchemaValidator.matchesJsonSchema(schema));
//




    }
}
