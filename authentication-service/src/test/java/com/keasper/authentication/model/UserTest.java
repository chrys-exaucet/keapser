package com.keasper.authentication.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class UserTest {

	private User user;
	
	@Test
	@DisplayName("Teste un utilisateur")
	void test() {
		user = new User ();
		assertThat(user).isNotNull();
		user = new User(1L,"Bouf","Jen","derdson@gmail.com","Benin",(int)979918, LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn");
		assertEquals(user.getCreatedAccount().getMinute(), LocalTime.now().getMinute());;
	}

}
