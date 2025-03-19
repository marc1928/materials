package com.materialstech.productservice.service;

import com.materialstech.productservice.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    // créer un nouveau produit
    ProductDTO createProduct(ProductDTO productDTO);

    // Mettre à jour un produit
    Optional<ProductDTO> updateProduct(Long id, ProductDTO productDTO);

    // Supprimer un produit
    void deleteProduct(Long id);

    // Récupérer un produit à parti de son Id
    Optional<ProductDTO> getProductById(Long id);

    // Récupérer tous les produits
    List<ProductDTO> getAllProducts();

}
