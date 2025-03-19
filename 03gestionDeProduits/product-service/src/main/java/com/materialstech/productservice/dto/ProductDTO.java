package com.materialstech.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;

    private String name;

    private String description;

    private Double price;

    private String currency;


    private List<Long> categoryIds = new ArrayList<>();


    private List<Long> imageIds = new ArrayList<>();

}
