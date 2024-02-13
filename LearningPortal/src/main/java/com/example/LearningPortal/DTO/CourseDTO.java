package com.example.LearningPortal.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

	private long courseId;
	private String title;
	private String description;
	private Long authorId;
	private String category;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;

}
