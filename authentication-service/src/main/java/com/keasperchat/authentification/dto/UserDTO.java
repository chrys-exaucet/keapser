package com.keasperchat.authentification.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Id;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	@Id
	@JsonIgnore
	private long id;
	
	private String firstname;
	
	private String lastname;
	
	@Email
	private String email;
	
	
	private String country;
	
	private int tel;
	
	private LocalDate birthday;
	
	@JsonIgnore
	private LocalDateTime createdAccount;
	
	private String hashPass;
}
