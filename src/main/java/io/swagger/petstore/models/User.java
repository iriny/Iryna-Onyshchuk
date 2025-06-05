package io.swagger.petstore.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@JsonProperty("id")
	private int id;

	@JsonProperty("username")
	private String username;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("userStatus")
	private int userStatus;
}