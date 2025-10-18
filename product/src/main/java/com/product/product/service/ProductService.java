package com.product.product.service;

import com.product.product.dto.ProductDTO;
import com.product.product.entity.Category;
import com.product.product.entity.Product;
import com.product.product.exception.CategoryNotFoundException;
import com.product.product.mapper.ProductMapper;
import com.product.product.respository.CategoryRepository;
import com.product.product.respository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;


    public ProductDTO createProduct(ProductDTO productDTO) {

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()-> new CategoryNotFoundException("Category" +productDTO.getCategoryId() +" not found"));

        Product product = ProductMapper.toProductEntity(productDTO, category);

        product = productRepository.save(product);

        return ProductMapper.toProductDTO(product);
    }

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();
    }

    public ProductDTO getProductById(Long id){
        Product product=productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
        return ProductMapper.toProductDTO(product);
    }

    public String deleteProductById(Long id){
         productRepository.deleteById(id);
        return "product " + id + "has been deleted";
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO){
        Product product=productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));


       Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()-> new RuntimeException("Category not found"));

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productRepository.save(product);

        return ProductMapper.toProductDTO(product);


    }



}
