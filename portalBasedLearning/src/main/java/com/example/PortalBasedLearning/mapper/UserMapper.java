package com.example.PortalBasedLearning.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.portalBasedLearning.dto.UserDto;
import com.example.portalBasedLearning.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserMapper INSTANCE=Mappers.getMapper(UserMapper.class);
	
	@Mapping(target = "createdOn" , expression = "java(dateTimeformatter.formatTimestamp(user.getCreatedOn()))")
	@Mapping(target = "updatedOn" , expression = "java(dateTimeformatter.formatTimestamp(user.getOn()))")
	@Mapping(source="user.role", target="role")
	UserDto userEntityToUserDto(UserEntity user);
	
	UserDto userDtoToUserEntity(UserDto userdto);
}
