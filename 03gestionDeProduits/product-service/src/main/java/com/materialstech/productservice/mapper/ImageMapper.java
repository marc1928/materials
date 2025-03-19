package com.materialstech.productservice.mapper;

import com.materialstech.productservice.dto.ImageDTO;
import com.materialstech.productservice.entity.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper extends EntityMapper<ImageDTO, Image> {


    ImageDTO toDto(Image entity);

    Image toEntity(ImageDTO dto);


    default Image fromId(Long id) {
        if (id == null) {
            return null;
        }
        Image image = new Image();
        image.setId(id);
        return image;
    }

}
