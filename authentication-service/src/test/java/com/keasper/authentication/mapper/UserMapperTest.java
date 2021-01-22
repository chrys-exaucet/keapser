package com.keasper.authentication.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.keasper.authentication.dto.UserDTO;
import com.keasper.authentication.model.User;


@ExtendWith(SpringExtension.class)
class UserMapperTest {
	

	
	
	public final UserMapper mapper =  UserMapper.INSTANCE;
	
	
	

	@Test
	@DisplayName("Teste le mapping vers DTO")
	void testToDto() {
		
		User user = new User(1L,"Bouf","Jen","derdson@gmail.com","Benin","+221979918", LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn"); 
		
		UserDTO userDto = mapper.toDto(user);
		
		assertThat(user.getId()).isEqualTo(userDto.getId());
		assertThat(user.getFirstname()).isEqualTo(userDto.getFirstname());
		assertThat(user.getLastname()).isEqualTo(userDto.getLastname());
		assertThat(user.getEmail()).isEqualTo(userDto.getEmail());
		assertThat(user.getCountry()).isEqualTo(userDto.getCountry());
		assertThat(user.getTel()).isEqualTo(userDto.getTel());
		assertThat(user.getBirthday()).isEqualTo(userDto.getBirthday());
		assertThat(user.getCreatedAccount()).isEqualTo(userDto.getCreatedAccount());
		assertThat(user.getHashPass()).isEqualTo(userDto.getHashPass());
		
		
	}

	@Test
	@DisplayName("Teste le mapping de Dto vers User")
	void testFromDto() {
		
		UserDTO userDto = new UserDTO(1L,"Bouf","Jen","derdson@gmail.com","Benin","+221979918", LocalDate.of(1999, 5, 26), LocalDateTime.now(), "gjn");
		
		User user = mapper.fromDto(userDto);
		
		assertThat(userDto.getId()).isEqualTo(user.getId());
		assertThat(userDto.getFirstname()).isEqualTo(user.getFirstname());
		assertThat(userDto.getLastname()).isEqualTo(userDto.getLastname());
		assertThat(userDto.getEmail()).isEqualTo(user.getEmail());
		assertThat(userDto.getCountry()).isEqualTo(user.getCountry());
		assertThat(userDto.getTel()).isEqualTo(user.getTel());
		assertThat(userDto.getBirthday()).isEqualTo(user.getBirthday());
		assertThat(userDto.getCreatedAccount()).isEqualTo(user.getCreatedAccount());
		assertThat(userDto.getHashPass()).isEqualTo(user.getHashPass());
	}

}
