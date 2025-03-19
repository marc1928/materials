package com.materialstech.productservice.serviceImpl;

import com.materialstech.productservice.dto.CategoryDTO;
import com.materialstech.productservice.entity.Category;
import com.materialstech.productservice.mapper.CategoryMapper;
import com.materialstech.productservice.repository.CategoryRepository;
import com.materialstech.productservice.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {


    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

// Ajouter une nouvelle catégorie
    @Override
    public CategoryDTO addNewCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.toEntity(categoryDTO);
        categoryRepository.save(category);
        return categoryMapper.toDto(category);
    }
// Modifier une catégory
    @Override
    public Optional<CategoryDTO> updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        category.setName(categoryDTO.getName());
        category = categoryRepository.save(category);
        return Optional.of(categoryMapper.toDto(category));
    }

// Récupérer une catégory par son Id
    @Override
    public Optional<CategoryDTO> getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category not found with id: " + id));
        return Optional.of(categoryMapper.toDto(category));
    }


// Récupérer toutes les catégory
    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

// Supprimer une catégory
    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
