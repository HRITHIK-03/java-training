package com.example.LearningPortal.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.Entity.Course;
import com.example.LearningPortal.Repo.CourseRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public Course saveCourse(Course course) {

		course.setCreatedOn(LocalDateTime.now());
		course.setUpdatedOn(LocalDateTime.now());
		return courseRepository.save(course);
	}

	public Course getCourseById(long courseId) {
		Optional<Course> courseOptional = courseRepository.findById(courseId);

		if (!courseOptional.isPresent())
			return null;
		return courseOptional.get();
	}

	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	public Course updateCourse(Long id, Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

}
