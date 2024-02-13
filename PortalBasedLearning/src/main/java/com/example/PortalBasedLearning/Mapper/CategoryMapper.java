package com.example.PortalBasedLearning.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.PortalBasedLearning.Entity.CategoryEntity;
import com.example.PortalBasedLearning.dto.CategoryDto;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	CategoryMapper INSTANCE=Mappers.getMapper(CategoryMapper.class);
	
	@Mapping(target = "createdOn" , expression = "java(dateTimeformatter.formatTimestamp(user.getCreatedOn()))")
	@Mapping(target = "updatedOn" , expression = "java(dateTimeformatter.formatTimestamp(user.getOn()))")
	CategoryDto categoryEntityTocategoryDto(CategoryEntity category);
	
	CategoryDto categoryDtoTocategoryEntity(CategoryDto category);

}
