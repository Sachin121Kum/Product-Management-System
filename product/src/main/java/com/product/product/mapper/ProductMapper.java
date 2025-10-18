package com.product.product.mapper;

import com.product.product.dto.ProductDTO;
import com.product.product.entity.Category;
import com.product.product.entity.Product;

public class ProductMapper {

    // Entity -> DTO
    public static ProductDTO toProductDTO(Product product) {


        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory() != null ? product.getCategory().getId() : null
        );
    }

    // DTO -> Entity
    public static Product toProductEntity(ProductDTO productDTO, Category category) {

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);

        return product;
    }
}
