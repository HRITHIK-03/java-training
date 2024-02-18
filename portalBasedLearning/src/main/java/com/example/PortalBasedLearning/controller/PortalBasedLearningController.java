package com.example.PortalBasedLearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.portalBasedLearning.dto.CourseDto;
import com.example.portalBasedLearning.dto.UserDto;
import com.example.portalBasedLearning.entity.CourseEntity;
import com.example.portalBasedLearning.service.CategoryService;
import com.example.portalBasedLearning.service.CourseService;
import com.example.portalBasedLearning.service.EnrollmentService;
import com.example.portalBasedLearning.service.FavouritesService;
import com.example.portalBasedLearning.service.UserService;

import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api")
public class PortalBasedLearningController {
	@Autowired
	private UserService userService;

	@Autowired
	private FavouritesService favouritesService;

	@Autowired
	private EnrollmentService enrollmentService;

	@Autowired
	private CourseService courseService;

	private final CategoryService categoryService;

    PortalBasedLearningController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

	//@PreAuthorize("hasRole('AUTHOR')")
	@PostMapping("/author/createCourse")
	public ResponseEntity<String> createCourse(@RequestBody CourseDto coursedto) {
		courseService.createCourse(coursedto);
		return ResponseEntity.status(HttpStatus.CREATED).body("course Created Successfully");
	}

	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/author/createUser")
	public ResponseEntity<String> createUser(@RequestBody UserDto userdto) {
		return ResponseEntity.status(HttpStatus.CREATED).body("user created successfully");
	}

	@GetMapping
	public ResponseEntity<CourseEntity> getCourseById(@PathVariable long courseId) {
		CourseEntity courseDTO = courseService.getCourseById(courseId);
		if (courseDTO != null) {
			return ResponseEntity.ok(courseDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
