package com.materialstech.productservice.serviceImpl;

import com.materialstech.productservice.dto.ProductDTO;
import com.materialstech.productservice.entity.Category;
import com.materialstech.productservice.entity.Image;
import com.materialstech.productservice.entity.Product;
import com.materialstech.productservice.mapper.ProductMapper;
import com.materialstech.productservice.repository.CategoryRepository;
import com.materialstech.productservice.repository.ImageRepository;
import com.materialstech.productservice.repository.ProductRepository;
import com.materialstech.productservice.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    private final ImageRepository imageRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductMapper productMapper,
                              CategoryRepository categoryRepository,
                              ImageRepository imageRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);

        if (productDTO.getCategoryIds() != null && !productDTO.getCategoryIds().isEmpty()) {
            List<Category> categories = categoryRepository.findAllById(productDTO.getCategoryIds());
            product.setCategories(categories);
        }

        if (productDTO.getImageIds() != null && !productDTO.getImageIds().isEmpty()) {
            List<Image> images = imageRepository.findAllById(productDTO.getImageIds());
            product.setImages(images);
        }

        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }


    @Override
    public Optional<ProductDTO> updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCurrency(productDTO.getCurrency());

        Product updatedProduct = productRepository.save(product);
        return Optional.of(productMapper.toDto(updatedProduct));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<ProductDTO> getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return Optional.of(productMapper.toDto(product));
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }
}
