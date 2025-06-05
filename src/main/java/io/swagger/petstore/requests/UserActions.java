package io.swagger.petstore.requests;


import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.swagger.petstore.models.User;

import static io.restassured.RestAssured.given;

public class UserActions {

    String BASE_USER_PATH = "/user/";

    @Step("Create new user")
    public Response create(User user) {
        return given().contentType(ContentType.JSON)
                .body(user)
                .when()
                .post(BASE_USER_PATH)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .extract().response();
    }

    @Step("Edit user {username}")
    public Response edit(String username, User user) {
        return given().contentType(ContentType.JSON)
                .body(user)
                .when()
                .put(BASE_USER_PATH + username)
                .then()
                 .log().ifValidationFails()
                .statusCode(200)
                .extract().response();
    }

    @Step("Get user {username}")
    public Response getUser(String username) {
        return given().contentType(ContentType.JSON)
                .when()
                .get(BASE_USER_PATH + username)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .extract().response();
    }

    @Step("Delete user {username}")
    public Response delete(String username) {
        return given().contentType(ContentType.JSON)
                .when()
                .delete(BASE_USER_PATH + username)
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .extract().response();
    }
}
