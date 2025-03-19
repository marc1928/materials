package com.materialstech.productservice.service;

import com.materialstech.productservice.dto.ImageDTO;

import java.util.List;
import java.util.Optional;

public interface ImageService {

    // Ajouter de nouvelles images
    ImageDTO addNewImage(ImageDTO imageDTO);

    // mettre à jour une image
    Optional<ImageDTO> updateImage(Long id, ImageDTO imageDTO);

    // Récupérer une image à partir de son ID
    Optional<ImageDTO> getImageById(Long id);

    // Récupérer toutes les images
    List<ImageDTO> getAllImage();

    // Supprimer une image
    void deleteImageById(Long id);

}
