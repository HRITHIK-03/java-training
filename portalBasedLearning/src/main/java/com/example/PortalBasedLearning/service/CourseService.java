package com.example.PortalBasedLearning.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portalBasedLearning.dto.CourseDto;
import com.example.portalBasedLearning.entity.CourseEntity;
import com.example.portalBasedLearning.mapper.CourseMapper;
import com.example.portalBasedLearning.repository.Courserepoisitory;

@Service
public class CourseService {
	@Autowired
	private CourseMapper courseMapper;
	
	@Autowired
	private Courserepoisitory courserepoisitory;
	
	public CourseEntity saveCourse(CourseEntity course)
	{
		course.setCreatedOn(LocalDateTime.now());
		course.setUpdatedOn(LocalDateTime.now());
		return courserepoisitory.save(course);
		
	}
	public CourseEntity getCourseById(long courseId)
	{
		return courserepoisitory.findById(courseId).orElse(null);
	}
	public List<CourseEntity> getAllCourses()
	{
		Logger.info("Recieved all courses");
		return courserepoisitory.findAll();
	}
	
	public void createCourse(CourseDto courseDto)
	{
		CourseEntity courseEntity=courseMapper.courseDtoToCourseentity(courseDto);
		courserepoisitory.save(courseEntity);
	}

}
