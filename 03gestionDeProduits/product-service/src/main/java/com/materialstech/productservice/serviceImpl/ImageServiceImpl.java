package com.materialstech.productservice.serviceImpl;

import com.materialstech.productservice.dto.ImageDTO;
import com.materialstech.productservice.entity.Image;
import com.materialstech.productservice.mapper.ImageMapper;
import com.materialstech.productservice.repository.ImageRepository;
import com.materialstech.productservice.service.ImageService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    private final ImageMapper imageMapper;
    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageMapper imageMapper, ImageRepository imageRepository) {
        this.imageMapper = imageMapper;
        this.imageRepository = imageRepository;
    }

    @Override
    public ImageDTO addNewImage(ImageDTO imageDTO) {
        Image image = imageMapper.toEntity(imageDTO);
        imageRepository.save(image);
        return imageMapper.toDto(image);
    }

    @Override
    public Optional<ImageDTO> updateImage(Long id, ImageDTO imageDTO) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Image not found"));

        image.setName(imageDTO.getName());
        image.setUrl(imageDTO.getUrl());
        Image image1 = imageRepository.save(image);
        return Optional.of(imageMapper.toDto(image1));
    }

    @Override
    public Optional<ImageDTO> getImageById(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Image not found"));
        return Optional.of(imageMapper.toDto(image));
    }

    @Override
    public List<ImageDTO> getAllImage() {
        List<Image> images = imageRepository.findAll();
        return images.stream()
                .map(imageMapper::toDto)
                .toList();
    }

    @Override
    public void deleteImageById(Long id) {
        imageRepository.deleteById(id);
    }
}
