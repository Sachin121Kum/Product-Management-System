package com.product.product.controller;

import com.product.product.dto.ProductDTO;
import com.product.product.respository.ProductRepository;
import com.product.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Product REST API CRUD Operation",
        description = "CREATE READ UPDATE DELETE OPERATIONS FOR PRODUCT REST API "
)
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @Operation(
            summary = "Get All Products",
            description = "Rest api to Fetch All Products"
    )
    @GetMapping
    public List<ProductDTO> getAllProduct(){
        return productService.getAllProducts();
    }

    @Operation(
            summary = "fetch product by  Products id",
            description = "Rest api to Fetch  Products by id"
    )
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @DeleteMapping("/{id}")
    public  String deleteProductById(@PathVariable Long id){
        return productService.deleteProductById(id);
    }


    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id,@RequestBody ProductDTO productDTO){
            return productService.updateProduct(id,productDTO);
    }


    @Operation(
            summary = "Create Product",
            description = "create Product"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PreAuthorize("hasAuthority('ROLE_SELLER')")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){

        ProductDTO createdProduct=  productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct,HttpStatus.CREATED);
    }


}
