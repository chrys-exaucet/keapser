package com.keasper.authentication.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Id;
import javax.validation.constraints.*;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User", description = "Represents a user either an admin or a simple one")
public class UserDTO {
	@Id
	private long id;

	@NotEmpty(message="Firstname cannot be empty")
	private String firstname;


	@NotEmpty(message="Lastname cannot be empty")
	private String lastname;

	@Email(message="Email should be valid")
	private String email;

	@NotEmpty(message="Country should be valid")
	private String country;

	@Size(min=5, max=10, message="Telephone should be valid")
	@NotBlank(message="Telephone should be valid : not blank character")
	private String tel;

	@Past(message="Birthday is not past")
	private LocalDate birthday;

	private LocalDateTime createdAccount;

	@NotEmpty(message="Password cannot be empty")
	private String hashPass;
}
