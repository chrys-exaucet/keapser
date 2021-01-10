package com.keasperchat.authentification.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.keasperchat.authentification.dto.UserDTO;
import com.keasperchat.authentification.model.User;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	
	UserDTO toDto(User user);
	
	@InheritInverseConfiguration
	User fromDto(UserDTO userDTO);
}
