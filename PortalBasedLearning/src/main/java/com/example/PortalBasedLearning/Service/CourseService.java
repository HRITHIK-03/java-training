package com.example.PortalBasedLearning.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PortalBasedLearning.Entity.CourseEntity;
import com.example.PortalBasedLearning.Mapper.CourseMapper;
import com.example.PortalBasedLearning.Repository.Courserepoisitory;
import com.example.PortalBasedLearning.dto.CourseDto;

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
		return courserepoisitory.findAll();
	}
	
	public void createCourse(CourseDto courseDto)
	{
		CourseEntity courseEntity=courseMapper.courseDtoToCourseentity(courseDto);
		courserepoisitory.save(courseEntity);
	}

}
