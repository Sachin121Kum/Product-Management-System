package com.product.product.dto;

import com.product.product.entity.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        name = "Product",
        description = "it holds Product Information"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {


    private Long id;
    private String name;
    private String description;
    private String price;
    private Long CategoryId;
}
