package com.keasperchat.authentification.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.keasperchat.authentification.dao.UserDao;
import com.keasperchat.authentification.model.User;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserService.class)
class UserServiceTest {

	@MockBean
	private UserDao userDao;

	@Autowired
	private UserService userService;

	@Test
	@DisplayName("Teste pour verifier qu'il retourne tous les utilissateurs")
	void testFindAll() {
		List<User> users = Arrays.asList(new User(1L,"Bouf","Jen","derdson@gmail.com","Benin",(int)979918, LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn"),
				new User(2L,"Bojf","Jen","derdson@gmail.com","Benin",(int)979918, LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn"));
		Mockito.when(userDao.findAll()).thenReturn(users);

		assertThat(userService.findAll()).isEqualTo(userDao.findAll());
	}

	@Test
	@DisplayName("Verifie qui trouve un utilisateur ou pas par ID")
	void testFindById() {
		User user = new User(1L,"Bouf","Jen","derdson@gmail.com","Benin",(int)979918, LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn");
		Mockito.when(userDao.findById(1L)).thenReturn(Optional.of(user));
		assertThat(userService.findById(1L)).isEqualTo(userDao.findById(1L).get());
		assertThat(userService.findById(2L)).isNull();
		assertThat(userService.findById(0L)).isNull();
	}


	@Test
	@DisplayName("Verifie qui trouve un utilisateur ou pas par FirstName")
	void testFindByFirstName() {
		User user = new User(1L,"Bouf","Jen","derdson@gmail.com","Benin",(int)979918,LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn");
		Mockito.when(userDao.findByFirstname("Bouf")).thenReturn(user);
		assertThat(userService.findByFirstName("Bouf")).isEqualTo(userDao.findByFirstname("Bouf"));
		assertThat(userService.findByFirstName("")).isNull();
		assertThat(userService.findByFirstName("Hello")).isNull();
	}


	@Test
	@DisplayName("Verifie qui trouve un utilisateur ou pas par LastName")
	void testFindByLastName() {
		User user = new User(1L,"Bouf","Jen","derdson@gmail.com","Benin",(int)979918, LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn");
		Mockito.when(userDao.findByLastname("Jen")).thenReturn(user);
		assertThat(userService.findByLastName("Jen")).isEqualTo(userDao.findByLastname("Jen"));
		assertThat(userService.findByLastName("")).isNull();
		assertThat(userService.findByLastName("Jon")).isNull();
	}


	@Test
	@DisplayName("Verifie qu'un user est sauvegardé")
	void testSave() {
		User user = new User(1L,"Bouf","Jen","derdson@gmail.com","Benin",(int)979918, LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn");
		Mockito.when(userDao.save(user)).thenReturn(user);

		assertThat(userService.save(user)).isEqualTo(user);
		assertThat(userService.save(user).getLastname()).isEqualTo("Jen");

		assertThat(userService.save(new User())).isNotEqualTo(user);
	}

	@Test
	@DisplayName("Verifie qu'il met à jour un user")
	void testUpdate() {
		User user = new User(10L,"Bouf","Jen","derdson@gmail.com","Benin",(int)979918, LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn");
		Mockito.when(userDao.findById(user.getId())).thenReturn(Optional.of(user));
		user.setLastname("Beef");
		assertThat(userService.update(user)).isNotEqualTo(user);

	}

	@Test
	void testDelete() {

		User user = new User(1L,"Bouf","Jen","derdson@gmail.com","Benin",(int)979918,  LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn");
		
		Mockito.when(userDao.findById(user.getId())).thenReturn(Optional.of(user));
		
		assertThat(userService.delete(user)).isTrue();
		assertThat(userService.delete(new User())).isFalse();
		

	}


}
