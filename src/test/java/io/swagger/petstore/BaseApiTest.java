package io.swagger.petstore;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {

    @BeforeAll
    static void setBaseUri() {
        RestAssured.baseURI = "http://localhost:8080/api/v3";
    }

    protected <T> T request(Class<T> tClass) {
        try {
            return tClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
