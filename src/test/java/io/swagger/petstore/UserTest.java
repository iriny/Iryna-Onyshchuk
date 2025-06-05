package io.swagger.petstore;

import io.swagger.petstore.models.User;
import io.swagger.petstore.requests.UserActions;
import net.datafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class UserTest extends BaseApiTest {

    Faker faker = new Faker();

    String
            username = faker.internet().username(),
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            password = faker.internet().password(),
            phone = faker.phoneNumber().subscriberNumber();
    int
            UUID = faker.number().randomDigit(),
            userStatus = 10;

    @Test
    @DisplayName("Check CRUD operations for user")
    public void checkUserCrudOperations() {
        request(UserActions.class).create(new User(
                        UUID,
                        username,
                        firstName,
                        lastName,
                        email,
                        password,
                        phone,
                        userStatus));
        String updatedFirstName = request(UserActions.class).edit(username, new User(
                        UUID,
                        username,
                        firstName + faker.name().suffix(),
                        lastName,
                        email,
                        password,
                        phone,
                        userStatus)).path("firstName");
        request(UserActions.class)
                .getUser(username)
                .then().body("firstName", equalTo(updatedFirstName));
        request(UserActions.class)
                .delete(username);
    }
}
