package com.materialstech.productservice.service;

import com.materialstech.productservice.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    // Ajouter une nouvelle catégorie
    CategoryDTO addNewCategory(CategoryDTO categoryDTO);

    // Modifier une catégorie
    Optional<CategoryDTO> updateCategory(Long id, CategoryDTO categoryDTO);

    // récupérer une catégorie à partir de son Id
    Optional<CategoryDTO> getCategoryById(Long id);

    // Récupérer toutes les catégories
    List<CategoryDTO> getAllCategory();

    // Supprimer une catégorie
    void deleteCategoryById(Long id);

}
