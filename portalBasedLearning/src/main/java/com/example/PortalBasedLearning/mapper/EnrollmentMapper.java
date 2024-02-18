package com.example.PortalBasedLearning.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.portalBasedLearning.dto.EnrollmentDto;
import com.example.portalBasedLearning.entity.EnrollmentEntity;

@Mapper(componentModel = "spring", uses = {UserMapper.class, CourseMapper.class})
public interface EnrollmentMapper {
	EnrollmentMapper iNSTANCE=Mappers.getMapper(EnrollmentMapper.class);
	
	@Mapping(target = "createdOn" , expression = "java(dateTimeformatter.formatTimestamp(user.getCreatedOn()))")
	@Mapping(target = "updatedOn" , expression = "java(dateTimeformatter.formatTimestamp(user.getOn()))")
	@Mapping(source="enrollment.learner.userId", target = "learnerId")
	EnrollmentDto enrollmentEntityToEnrollmentDto(EnrollmentEntity enrollment);
	
	EnrollmentEntity enrollmentDtoToEnrollmentEntity(EnrollmentDto enrollmentDto);

}
