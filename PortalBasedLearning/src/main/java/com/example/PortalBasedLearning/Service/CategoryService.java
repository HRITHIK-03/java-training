package com.example.PortalBasedLearning.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PortalBasedLearning.Entity.CategoryEntity;
import com.example.PortalBasedLearning.Repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public CategoryEntity saveCategory(CategoryEntity category)
	{
		return categoryRepository.save(category);
	}

	public CategoryEntity getCategoryById(long categoryId)
	{
		return categoryRepository.findById(categoryId).orElse(null);
	}
	public List<CategoryEntity> findAllCategories()
	{
		return categoryRepository.findAll();
	}

}
