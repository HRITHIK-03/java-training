package com.example.LearningPortal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LearningPortal.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	//	public Category save(Category category) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}
	//
	//	public static Object findById(long categoryId) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}

}
