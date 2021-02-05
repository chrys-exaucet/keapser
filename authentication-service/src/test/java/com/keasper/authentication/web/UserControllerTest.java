package com.keasper.authentication.web;




import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import com.keasper.authentication.dto.UserDTO;
import com.keasper.authentication.mapper.UserMapper;
import com.keasper.authentication.model.User;
import com.keasper.authentication.service.UserService;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

	@MockBean
	private UserService userService; 

	@Autowired
	private MockMvc mock ;

	public final UserMapper mapper =  UserMapper.INSTANCE;


	@Test
	@DisplayName("Teste et verifie que tous les utilisateurs sont renvoyé ")
	void testGetEmployees() throws Exception {


		List<UserDTO> usersDTO = Arrays.asList(new UserDTO(1L,"Bou","Jen","deron@gmail.com","Benin","+221979918", LocalDate.of(1999, 5, 26), LocalDateTime.of(2020, 12, 22, 12, 34,45), "gjn"),
				new UserDTO(2L,"Bouf","Jen","derdson@gmail.com","Benin","+221979918",LocalDate.of(1999, 5, 26), LocalDateTime.of(2020, 12, 22, 12, 34,45), "gjn"),
				new UserDTO(3L,"Boud","Jen","deroffn@gmail.com","Benin","+221979918", LocalDate.of(1999, 5, 26), LocalDateTime.of(2020, 12, 22, 12, 34,45), "gjn"),
				new UserDTO(4L,"Boue","Jen","derqfezfon@gmail.com","Benin","+221979918", LocalDate.of(1999, 5, 26), LocalDateTime.of(2020, 12, 22, 12, 34,45), "gjn"));

		List<User> users= new ArrayList<>() ;
		usersDTO.forEach(e->users.add(mapper.fromDto(e)));
		Mockito.when(userService.findAll()).thenReturn(users);
		int i=0;
		for(UserDTO user: usersDTO) {

			mock.perform(get("/auth/users")).andExpect(status().isOk()).andDo(print())
			.andExpect(jsonPath("["+i+"].firstname").value(mapper.fromDto(user).getSurname()))
			.andExpect(jsonPath("["+i+"].lastname").value(mapper.fromDto(user).getName()))
			.andExpect(jsonPath("["+i+"].email").value(mapper.fromDto(user).getEmail()))
			.andExpect(jsonPath("["+i+"].country").value(mapper.fromDto(user).getCountry()))
			.andExpect(jsonPath("["+i+"].tel").value(mapper.fromDto(user).getTel()))
			.andExpect(jsonPath("["+i+"].birthday").value(mapper.fromDto(user).getBirthday().toString()))
			.andExpect(jsonPath("["+i+"].hashPass").value(mapper.fromDto(user).getPassword()));
			i++;
		}

		mock.perform(get("/auth/users")).andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("[3].email").value("derqfezfon@gmail.com"));
	}

	@Test
	@DisplayName("Teste la supperession d'un utilisateur par son id")
	void testDeleteEmployee() throws Exception {
		Mockito.when(userService.delete(1L)).thenReturn(true);
		mock.perform(delete("/auth/delete/1")).andExpect(status().isNoContent());
		mock.perform(delete("/auth/delete/2")).andExpect(status().isNotFound());
	}




}
