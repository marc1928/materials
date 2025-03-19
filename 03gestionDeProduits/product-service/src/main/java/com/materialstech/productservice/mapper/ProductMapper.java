package com.materialstech.productservice.mapper;

import com.materialstech.productservice.dto.ProductDTO;
import com.materialstech.productservice.entity.Product;
import com.materialstech.productservice.entity.Category;
import com.materialstech.productservice.entity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Collectors.class, Category.class, Image.class})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {

    @Mapping(target = "categoryIds", source = "categories.id")
    @Mapping(target = "imageIds", source = "images.id")
    ProductDTO toDto(Product product);

    @Mapping(target = "categories", source = "categoryIds")
    @Mapping(target = "images", source = "imageIds")
    Product toEntity(ProductDTO productDTO);


    default Product fromId(Long id) {
        if (id == null) {
            return null;
        }
        Product product = new Product();
        product.setId(id);
        return product;
    }
}
