package com.example.LearningPortal.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LearningPortal.Entity.Favorite;
import com.example.LearningPortal.Repo.FavoriteRepository;

@Service
public class FavoriteService {
	@Autowired
	private FavoriteRepository favoriteRepository;

	public Favorite favourite(Favorite favourite) {
		favourite.setCreatedOn(LocalDateTime.now());
		favourite.setUpdatedOn(LocalDateTime.now());
		return favoriteRepository.save(favourite);

	}

}
