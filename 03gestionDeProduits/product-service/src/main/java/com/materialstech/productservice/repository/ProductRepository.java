package com.materialstech.productservice.repository;

import com.materialstech.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    Optional<Product> findByName(String name);
    @NonNull
    @Override
    Optional<Product> findById(@NonNull Long id);
    boolean existsByName(String name);

}
