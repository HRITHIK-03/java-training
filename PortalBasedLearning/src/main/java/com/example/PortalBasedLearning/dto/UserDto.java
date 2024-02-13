package com.example.PortalBasedLearning.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	private long userID;
	private String username;
	private String password;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	

}
