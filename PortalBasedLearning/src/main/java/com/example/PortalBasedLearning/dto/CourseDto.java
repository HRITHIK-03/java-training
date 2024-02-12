package com.example.PortalBasedLearning.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
	private long courseId;
	private String title;
	private String description;
	private long authorid;
	private String category;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;

}
