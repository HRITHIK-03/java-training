package com.example.PortalBasedLearning.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PortalBasedLearning.Entity.FavouritesEntity;

@Repository
public interface FavouritesRepository extends JpaRepository<FavouritesEntity, Long> {

}
