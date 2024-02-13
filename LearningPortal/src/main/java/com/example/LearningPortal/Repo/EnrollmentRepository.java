package com.example.LearningPortal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LearningPortal.Entity.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

	//	public Enrollment save(Enrollment enrollment) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}

}
