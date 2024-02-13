package com.example.PortalBasedLearning.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouritesDto {
	private long favouriteId;
	private Long learnerId;
    private Long courseId;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
