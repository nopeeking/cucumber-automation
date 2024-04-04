package apiSamples;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.BookingDates;
import pojo.CreateBookingRequest;

public class SimplePostApi {
    public static void main(String[] args) {

//        Map<String, Object> requestBody = new HashMap<>();
//        Map<String, Object> bookingDates1 = new HashMap<>();
//        bookingDates1.put("checkin","2024-06-01");
//        bookingDates1.put("checkout","2025-01-01");
//        requestBody.put("firstname", "Jim");
//        requestBody.put("lastname", "Harper");
//        requestBody.put("totalprice", 1000);
//        requestBody.put("depositpaid", true);
//        requestBody.put("bookingdates", bookingDates1);
//        requestBody.put("additionalneeds", "Lunch");



        CreateBookingRequest createBookingRequest = new CreateBookingRequest();
        createBookingRequest.setFirstname("Tim");
        createBookingRequest.setLastname("Harper");
        createBookingRequest.setTotalprice(999);
        createBookingRequest.setDepositpaid(false);
        createBookingRequest.setAdditionalneeds("Mineral water");

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-01-01");
        bookingDates.setCheckout("2024-06-01");
        createBookingRequest.setBookingdates(bookingDates);

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.contentType(ContentType.JSON)
                .and().baseUri("https://restful-booker.herokuapp.com")
                .and().basePath("/booking")
                .and().filters(new ResponseLoggingFilter(), new RequestLoggingFilter())
                .and().body(createBookingRequest)
                .when().post();

    }

}
