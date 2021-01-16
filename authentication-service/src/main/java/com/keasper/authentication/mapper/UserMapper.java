package com.keasper.authentication.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.keasper.authentication.dto.UserDTO;
import com.keasper.authentication.model.User;

@Mapper
public interface UserMapper {
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	
	UserDTO toDto(User user);
	
	@InheritInverseConfiguration
	User fromDto(UserDTO userDTO);
}
