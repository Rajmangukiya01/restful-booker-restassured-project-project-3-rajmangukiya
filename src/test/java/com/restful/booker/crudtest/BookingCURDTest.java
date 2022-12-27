package com.restful.booker.crudtest;

import com.restful.booker.models.BookingPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BookingCURDTest extends TestBase {

    @Test
    public void getAllBookingIDs() {
        Response response = given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleBookingIDs() {
        Response response = given()
                .when()
                .get("/153");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void createBooking() {

        List<String> bookingDates = new ArrayList<>();
        bookingDates.add("2018-01-01");
        bookingDates.add("2019-01-01");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Lio");
        bookingPojo.setLastname("Messi");
        bookingPojo.setTotalPrice(1200);
        bookingPojo.setDepositPaid(true);
        bookingPojo.setBookingDates(bookingDates);
        bookingPojo.setAdditionalNeeds("Lunch");
        Response response =
                given().log().all()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                        .body(bookingPojo)
                        .when()
                        .post();
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void updateBooking() {

        List<String> bookingDates = new ArrayList<>();
        bookingDates.add("2018-01-01");
        bookingDates.add("2019-01-01");

        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Andre");
        bookingPojo.setLastname("Russell ");
        bookingPojo.setTotalPrice(1200);
        bookingPojo.setDepositPaid(true);
        bookingPojo.setBookingDates(bookingDates);
        bookingPojo.setAdditionalNeeds("Lunch");
        Response response =
                given().log().all()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                        .body(bookingPojo)
                        .when()
                        .put("/3460");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void partialUpdateBooking() {
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname("Rock");
        bookingPojo.setLastname("Rio");
        Response response =
                given().log().all()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                        .body(bookingPojo)
                        .when()
                        .patch("/1470");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void deleteBooking() {
        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .delete("/2559");
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
    public void pingCheck() {
        Response response = given().log().all()
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .get("https://restful-booker.herokuapp.com/ping");
        response.then().statusCode(201);
        response.prettyPrint();

    }

}
