package com.example.PortalBasedLearning.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserEntity {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long userId;
	
	private String username;
	private String password;
	
	@Enumerated(EnumType.STRING)
    private UserRole role;
    @OneToMany(mappedBy = "author")
    private java.util.List<CourseEntity> authoredCourses;
    
    @OneToMany(mappedBy = "learner")
    private java.util.List<EnrollmentEntity> enrollments;
    
    @OneToMany(mappedBy = "learner")
    private java.util.List<FavouritesEntity> favourites;

    @Column(name="Created_On", nullable=false, updatable = false)
	private LocalDateTime createdOn;
    
    @Column(name="Updated_On")
	private LocalDateTime updatedOn;
    

}
