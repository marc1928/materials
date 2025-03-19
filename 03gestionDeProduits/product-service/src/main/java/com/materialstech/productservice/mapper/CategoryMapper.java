package com.materialstech.productservice.mapper;

import com.materialstech.productservice.dto.CategoryDTO;
import com.materialstech.productservice.entity.Category;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDTO, Category> {

    CategoryDTO toDto(Category category);
    Category toEntity(CategoryDTO categoryDTO);

    default Category fromId(Long id) {
        if (id == null) {
            return null;
        }
        Category category = new Category();
        category.setId(id);
        return category;
    }
}
