package com.example.PortalBasedLearning.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PortalBasedLearning.Entity.FavouritesEntity;
import com.example.PortalBasedLearning.Repository.FavouritesRepository;

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
