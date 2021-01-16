package com.keasper.authentication.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Id;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	private String firstname;
	
	private String lastname;
	
	@Email
	private String email;
	
	
	private String country;
	
	private int tel;
	
	private LocalDate birthday;

	private LocalDateTime createdAccount;
	
	private String hashPass;
}
