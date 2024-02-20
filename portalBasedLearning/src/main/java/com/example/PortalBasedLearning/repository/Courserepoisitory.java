package com.example.PortalBasedLearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portalBasedLearning.entity.CourseEntity;

@Repository
public interface Courserepoisitory extends JpaRepository<CourseEntity, Long>{
  @Query(value = "SELECT * from Course c WHERE c.title = ?1", nativeQuery = true)
	List<Course> findAllJavaCourses(String name);

}
