package com.example.LearningPortal.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LearningPortal.Entity.Course;
import com.example.LearningPortal.Service.CategoryService;
import com.example.LearningPortal.Service.CourseService;
import com.example.LearningPortal.Service.EnrollmentService;
import com.example.LearningPortal.Service.FavoriteService;
import com.example.LearningPortal.Service.UserService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class LearningPortalController {

	@Autowired
	private UserService userService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private EnrollmentService enrollmentService;

	@Autowired
	private FavoriteService favoriteService;

	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> courses = courseService.getAllCourses();
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
		Optional<Course> course = Optional.ofNullable(courseService.getCourseById(id));
		return course.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/course/create")
	public ResponseEntity<Course> createCourse(@RequestBody Course course) {
		Course createdCourse = courseService.createCourse(course);
		return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
	}

	@PutMapping("/course/update/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
		Optional<Course> existingCourse = Optional.ofNullable(courseService.getCourseById(id));
		if (existingCourse.isPresent()) {
			Course updatedCourse = courseService.updateCourse(id, course);
			return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
