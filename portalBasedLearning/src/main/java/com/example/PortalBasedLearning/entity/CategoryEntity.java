package com.example.PortalBasedLearning.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryId;
	
	
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<CourseEntity> courses;
	
	@Column(name="created_on", updatable=false, nullable=false)
	private LocalDateTime createdOn;
	
	@Column(name="updated_on")
	private LocalDateTime updatedOn;
}
