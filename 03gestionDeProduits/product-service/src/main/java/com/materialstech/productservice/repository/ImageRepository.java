package com.materialstech.productservice.repository;

import com.materialstech.productservice.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {

    @Override
    @NonNull
    Optional<Image> findById(@NonNull Long id);
    Optional<Image> findByName(String name);
}
