package com.product.product.controller;

import com.product.product.dto.CategoryDTO;
import com.product.product.exception.CategoryAlreadyExistException;
import com.product.product.service.CategoryService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@Tag(
        name = "Category REST API CRUD Operation",
        description = "CREATE READ UPDATE DELETE OPERATIONS FOR CATEGORY REST API "
)
@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping

    public List<CategoryDTO> getAll(){
        return categoryService.getAllCategories();
    }

    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){

          CategoryDTO saveCategory =  categoryService.createCategory(categoryDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(saveCategory) ;

    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id){
    return categoryService.getCategoryById(id);

    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);


    }

}
