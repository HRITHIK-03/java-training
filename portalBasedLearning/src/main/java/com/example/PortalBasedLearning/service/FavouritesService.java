package com.example.PortalBasedLearning.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portalBasedLearning.entity.FavouritesEntity;
import com.example.portalBasedLearning.repository.FavouritesRepository;

@Service
public class FavouritesService {
	@Autowired
	private FavouritesRepository favouritesRepository;
	
	public FavouritesEntity saveFavourite(FavouritesEntity favourites)
	{
		favourites.setCreatedOn(LocalDateTime.now());
		favourites.setUpdatedOn(LocalDateTime.now());
		return favouritesRepository.save(favourites);
	}
	public FavouritesEntity getFavouritesById(long favouritesId)
	{
		return favouritesRepository.findById(favouritesId).orElse(null);
	}
	public List<FavouritesEntity> getAllFavourites()
	{
		return favouritesRepository.findAll();
	}
}
