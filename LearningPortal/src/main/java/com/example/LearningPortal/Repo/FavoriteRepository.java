package com.example.LearningPortal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LearningPortal.Entity.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

	//	public Favourite save(Favourite favourite) {
	//		// TODO Auto-generated method stub
	//		return null;
	//	}

}
