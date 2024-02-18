package com.example.PortalBasedLearning.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.portalBasedLearning.entity.EnrollmentEntity;
import com.example.portalBasedLearning.repository.EnrollmentRepository;

@Service
public class EnrollmentService {
	private EnrollmentRepository enrollmentRepository;
	
	public EnrollmentEntity saveEnrollment(EnrollmentEntity enrollment)
	{
		enrollment.setCreatedOn(LocalDateTime.now());
		enrollment.setUpdatedOn(LocalDateTime.now());
		return enrollmentRepository.save(enrollment);
	}
	
	public EnrollmentEntity getEnrollmentById(long enrollmentId)
	{
		return enrollmentRepository.findById(enrollmentId).orElse(null);
	}
	
	public List<EnrollmentEntity> getAllEnrollments()
	{
		return enrollmentRepository.findAll();
	}

}
