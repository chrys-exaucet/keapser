package com.keasper.authentication.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
//Define a sequence - might also be in another class:
@SequenceGenerator(name="idSeq", initialValue=1, allocationSize=50)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="idSeq")
	private long id;

	@NotEmpty(message="Firstname cannot be empty")
	private String firstname;

	@NotEmpty(message="Lastname cannot be empty")
	private String lastname;


	@Email(message="Email should be valid")
	@Column(unique = true)
	private String email;

	@NotEmpty(message="Country should be valid")
	private String country;

	@Size(min=5, max=10, message="Telephone should be valid : cannot be empty")
	@NotBlank(message="Telephone should be valid : not blank character")
	@Column(unique = true)
	private String tel;

	@Past(message="Birthday is not past")
	private LocalDate birthday;

	private LocalDateTime createdAccount;

	@NotEmpty(message="Password cannot be empty")
	private String hashPass;


	@PrePersist
	private void onCreate() {
		this.setCreatedAccount(LocalDateTime.now());
	}

}
