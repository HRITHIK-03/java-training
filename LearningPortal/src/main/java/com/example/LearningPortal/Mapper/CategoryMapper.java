package com.example.LearningPortal.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.LearningPortal.DTO.CategoryDTO;
import com.example.LearningPortal.Entity.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

	CategoryDTO categoryToCategoryDTO(Category category);

	Category categoryDTOToCategory(CategoryDTO categoryDTO);

}
