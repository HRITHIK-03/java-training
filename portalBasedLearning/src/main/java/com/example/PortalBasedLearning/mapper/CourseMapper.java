package com.example.PortalBasedLearning.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.portalBasedLearning.dto.CourseDto;
import com.example.portalBasedLearning.entity.CourseEntity;

@Mapper(componentModel = "spring", uses={CategoryMapper.class, UserMapper.class})
public interface CourseMapper {
	CourseMapper iNSTANCE= Mappers.getMapper(CourseMapper.class);
	
	@Mapping(target = "createdOn" , expression = "java(dateTimeformatter.formatTimestamp(user.getCreatedOn()))")
	@Mapping(target = "updatedOn" , expression = "java(dateTimeformatter.formatTimestamp(user.getOn()))")
	CourseDto courseEntityToCourseDto(CourseEntity course);
	
	CourseEntity courseDtoToCourseentity(CourseDto course);

}
