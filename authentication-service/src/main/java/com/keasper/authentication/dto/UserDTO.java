package com.keasper.authentication.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Id;
import javax.validation.constraints.*;

import com.keasper.authentication.validator.ValidAge;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "User", description = "Represents a user either an admin or a simple one")
public class UserDTO {
	@Id
	@ApiModelProperty(value = "The identifier's user", example = "256")
	private long id;

	@ApiModelProperty(value = "The surname of user", example = "John", name = "Surname", required = true)
	@NotEmpty(message = "Surname cannot be empty")
	private String surname;

	@ApiModelProperty(value = "The name of user", example = "DOE", name = "Name", required = true)
	@NotEmpty(message = "Name cannot be empty")
	private String name;

	@ApiModelProperty(value = "The mail of user", example = "johndoe@yahoo.fr", name = "E-mail", required = true)
	@Email(message = "Email should be valid (Ex: johndoe@yahoo.fr)")
	private String email;

	@ApiModelProperty(value = "The country of user", example = "Djibouti", name = "Country", required = true)
	@NotEmpty(message = "Country should be valid")
	private String country;

	@ApiModelProperty(value = "The user's telephone number", example = "+25377910400", name = "Telephone", required = true)
	@Size(min = 5, max = 15, message = "Telephone should be valid (Min =5 , Max=15)")
	@NotBlank(message = "Telephone should be valid : not blank character")
	private String tel;

	@ApiModelProperty(value = "The user's birthday", example = "2000-02-09", name = "Bitrhday", required = true)
	@Past(message = "Birthday is not past. The resulting age must be between 12 and 100 years old.")
	@ValidAge()
	private LocalDate birthday;

	@ApiModelProperty(required = false, hidden = true)
	private LocalDateTime createdAccountDate;

	@ApiModelProperty(value = "The users's password \"hash\"", example = "p@sswordH@$$h", name = "Password", required = true)
	@NotEmpty(message = "Password cannot be empty")
	private String password;
}
