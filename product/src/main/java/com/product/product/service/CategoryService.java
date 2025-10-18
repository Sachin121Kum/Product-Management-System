package com.product.product.service;

import com.product.product.dto.CategoryDTO;
import com.product.product.entity.Category;
import com.product.product.exception.CategoryAlreadyExistException;
import com.product.product.mapper.CategoryMapper;
import com.product.product.respository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    private  CategoryRepository categoryRepository;

    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO){

        Optional<Category> optionalCategory=categoryRepository.findByName(categoryDTO.getName());

        if(optionalCategory.isPresent()){
            throw new CategoryAlreadyExistException("Category"  +categoryDTO.getName()+" Exist");
        }

        Category category =CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
       return CategoryMapper.toCategoryDTO((category));
    }

    public CategoryDTO getCategoryById(Long id){
       Category category= categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category Not Found"));
        return CategoryMapper.toCategoryDTO(category);

    }

    public String deleteCategory(Long id){
            categoryRepository.deleteById(id);
            return "Category "+ id+ "has been deleted";
    }


}
