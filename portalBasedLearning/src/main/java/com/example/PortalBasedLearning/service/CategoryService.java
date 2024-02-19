package com.example.PortalBasedLearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portalBasedLearning.entity.CategoryEntity;
import com.example.portalBasedLearning.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public CategoryEntity saveCategory(CategoryEntity category)
	{
		log.info("Saving category: {}", category);
		return categoryRepository.save(category);
	}

	public CategoryEntity getCategoryById(long categoryId)
	{
		log.info("Getting category by ID: {}", categoryId);
		return categoryRepository.findById(categoryId).orElse(null);
	}
	public List<CategoryEntity> findAllCategories()
	{
		return categoryRepository.findAll();
	}

}
