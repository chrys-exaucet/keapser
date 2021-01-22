package com.keasper.authentication.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.keasper.authentication.model.User;

class UserDTOTest {

	private User user;
	

	@Test
	@DisplayName("Teste un utilisateur DTO")
	void test() {
		user = new User ();
		assertThat(user).isNotNull();
		user = new User(1L,"Bouf","Jen","derdson@gmail.com","Benin","+221979918", LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn");
		assertEquals(user.getCreatedAccount().getMinute(), LocalTime.now().getMinute());
	}

}
