package com.keasper.authentication.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

import com.keasper.authentication.repository.UserRepository;
import com.keasper.authentication.exceptions.UserNotFoundException;
import com.keasper.authentication.model.User;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserService.class)
class UserServiceTest {

	@MockBean
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Test
	@DisplayName("Teste pour verifier qu'il retourne tous les utilissateurs")
	void testFindAll() {
		List<User> users = Arrays.asList(new User(1L,"Bouf","Jen","derdson@gmail.com","Benin","+221979918", LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn"),
				new User(2L,"Bojf","Jen","derdson@gmail.com","Benin","+221979918", LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn"));
		Mockito.when(userRepository.findAll()).thenReturn(users);

		assertThat(userService.findAll()).isEqualTo(userRepository.findAll());
	}

	@Test
	@DisplayName("Verifie qui trouve un utilisateur ou pas par ID")
	void testFindById() {
		User user = new User(1L,"Bouf","Jen","derdson@gmail.com","Benin","+221979918", LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn");
		Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
		assertThat(userService.findById(1L)).isEqualTo(userRepository.findById(1L).get());
		assertThrows(UserNotFoundException.class,()-> userService.findById(2L) );
		assertThrows(UserNotFoundException.class,()-> userService.findById(0L) );
	}


	@Test
	@DisplayName("Verifie qui trouve un utilisateur ou pas par FirstName")
	void testFindByFirstName() {
		User user = new User(1L,"Bouf","Jen","derdson@gmail.com","Benin","+221979918",LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn");
		Mockito.when(userRepository.findBySurname("Bouf")).thenReturn(user);
		assertThat(userService.findBySurname("Bouf")).isEqualTo(userRepository.findBySurname("Bouf"));
		assertThrows(NullPointerException.class, ()->userService.findBySurname(""));
	}


	@Test
	@DisplayName("Verifie qui trouve un utilisateur ou pas par LastName")
	void testFindByLastName() {
		User user = new User(1L,"Bouf","Jen","derdson@gmail.com","Benin","+221979918", LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn");
		Mockito.when(userRepository.findByName("Jen")).thenReturn(user);
		assertThrows(NullPointerException.class, ()->userService.findByName(""));
		assertThat(userService.findByName("Jen")).isEqualTo(userRepository.findByName("Jen"));

	}


	@Test
	@DisplayName("Verifie qu'un user est sauvegardé")
	void testSave() {
		User user = new User(1L,"Bouf","Jen","derdson@gmail.com","Benin","+221979918", LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn");
		Mockito.when(userRepository.save(user)).thenReturn(user);

		assertThat(userService.save(user)).isEqualTo(user);
		assertThat(userService.save(user).getName()).isEqualTo("Jen");

		assertThat(userService.save(new User())).isNotEqualTo(user);
	}

	@Test
	@DisplayName("Verifie qu'il met à jour un user")
	void testUpdate() {
		User user = new User(10L,"Bouf","Jen","derdson@gmail.com","Benin","+221979918", LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn");
		Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		user.setName("Beef");
		assertThat(userService.update(user)).isNotEqualTo(user);

	}

	@Test
	void testDelete() {

		User user = new User(1L,"Bouf","Jen","derdson@gmail.com","Benin","+221979918",  LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn");

		Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

		assertThat(userService.delete(user.getId())).isTrue();
		assertThrows(UserNotFoundException.class, ()->userService.delete(new User().getId()));


	}


}
