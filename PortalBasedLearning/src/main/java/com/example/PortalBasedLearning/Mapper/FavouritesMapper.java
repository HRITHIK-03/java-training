package com.example.PortalBasedLearning.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.PortalBasedLearning.Entity.FavouritesEntity;
import com.example.PortalBasedLearning.dto.FavouritesDto;

@Mapper(componentModel = "spring", uses= {UserMapper.class, CourseMapper.class})
public interface FavouritesMapper {
	FavouritesMapper INSTANCE=Mappers.getMapper(FavouritesMapper.class);
	
	@Mapping(target = "createdOn" , expression = "java(dateTimeformatter.formatTimestamp(user.getCreatedOn()))")
	@Mapping(target = "updatedOn" , expression = "java(dateTimeformatter.formatTimestamp(user.getOn()))")
	@Mapping(source = "favourites.learner.userId", target="learnerId")
	FavouritesDto favouriteEntityToFavouritesDto(FavouritesEntity favourite);
	
	FavouritesEntity favouriteDtoTofavouriteEntity(FavouritesDto favourite);

}
