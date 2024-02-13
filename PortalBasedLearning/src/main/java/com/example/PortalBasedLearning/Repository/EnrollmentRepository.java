package com.example.PortalBasedLearning.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PortalBasedLearning.Entity.EnrollmentEntity;

@Repository
public interface EnrollmentRepository extends JpaRepository<EnrollmentEntity, Long> {

}
