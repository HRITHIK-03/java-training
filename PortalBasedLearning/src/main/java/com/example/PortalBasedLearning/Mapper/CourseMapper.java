package com.example.PortalBasedLearning.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.PortalBasedLearning.Entity.CourseEntity;
import com.example.PortalBasedLearning.dto.CourseDto;

@Mapper(componentModel = "spring", uses={CategoryMapper.class, UserMapper.class})
public interface CourseMapper {
	CourseMapper iNSTANCE= Mappers.getMapper(CourseMapper.class);
	
	@Mapping(target = "createdOn" , expression = "java(dateTimeformatter.formatTimestamp(user.getCreatedOn()))")
	@Mapping(target = "updatedOn" , expression = "java(dateTimeformatter.formatTimestamp(user.getOn()))")
	CourseDto courseEntityToCourseDto(CourseEntity course);
	
	CourseEntity courseDtoToCourseentity(CourseDto course);

}
