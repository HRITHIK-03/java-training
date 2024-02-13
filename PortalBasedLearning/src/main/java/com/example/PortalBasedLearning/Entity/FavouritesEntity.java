package com.example.PortalBasedLearning.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouritesEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long favouriteId;
	
	@ManyToOne
	@JoinColumn(name="learner_id")
	private UserEntity learner;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private CourseEntity course;
	
	@Column(name="created_on", updatable = false, nullable = false)
	private LocalDateTime createdOn;
	
	@Column(name="updated_on")
	private LocalDateTime updatedOn;

}
