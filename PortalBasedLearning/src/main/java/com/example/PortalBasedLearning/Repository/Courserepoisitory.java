package com.example.PortalBasedLearning.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PortalBasedLearning.Entity.CourseEntity;

@Repository
public interface Courserepoisitory extends JpaRepository<CourseEntity, Long>{

}
