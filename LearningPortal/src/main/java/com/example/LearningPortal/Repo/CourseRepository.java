package com.example.LearningPortal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LearningPortal.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	//	public Course findByCourseId(long courseId);

	//	public static Course save(Course course) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}
	//
	//	public Object findById(long courseId) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}

}
