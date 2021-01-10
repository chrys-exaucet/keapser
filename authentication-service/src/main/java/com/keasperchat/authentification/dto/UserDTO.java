package com.keasperchat.authentification.dto;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Id;
import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", country=" + country + ", tel=" + tel + ", birthday=" + birthday+"0" + ", createdAccount="
				+ createdAccount + ", hashPass=" + hashPass + "]";
	}

	
	

}
