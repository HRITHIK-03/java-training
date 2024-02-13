package com.example.LearningPortal.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.DTO.UserDTO;
import com.example.LearningPortal.Entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mapping(source = "user.role", target = "role")
	UserDTO userToUserDTO(User user);

	User userDTOToUser(UserDTO userDTO);

}
