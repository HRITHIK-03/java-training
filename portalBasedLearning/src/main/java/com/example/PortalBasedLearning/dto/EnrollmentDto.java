package com.example.PortalBasedLearning.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentDto {
	private long enrollmentId;
	private Long learnerId;
    private Long courseId;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
