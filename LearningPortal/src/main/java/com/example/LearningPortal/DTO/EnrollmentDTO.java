package com.example.LearningPortal.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDTO {

	private Long enrollmentId;
	private long learnerId;
	private long courseId;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
}
