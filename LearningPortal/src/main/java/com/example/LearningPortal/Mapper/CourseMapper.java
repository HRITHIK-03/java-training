package com.example.LearningPortal.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.DTO.CourseDTO;
import com.example.LearningPortal.Entity.Course;

@Mapper(componentModel = "spring", uses = { CategoryMapper.class, UserMapper.class })
public interface CourseMapper {

	CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

	@Mapping(source = "course.author.userId", target = "authorId")
	@Mapping(source = "course.category.name", target = "category")
	CourseDTO courseToCourseDTO(Course course);

	Course courseDTOToCourse(CourseDTO courseDTO);

}
