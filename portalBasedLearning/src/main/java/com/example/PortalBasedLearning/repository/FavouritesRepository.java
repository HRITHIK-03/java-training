package com.example.PortalBasedLearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portalBasedLearning.entity.FavouritesEntity;

@Repository
public interface FavouritesRepository extends JpaRepository<FavouritesEntity, Long> {

}
