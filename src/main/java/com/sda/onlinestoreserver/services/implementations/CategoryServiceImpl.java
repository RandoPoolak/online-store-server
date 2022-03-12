package com.sda.onlinestoreserver.services.implementations;

import com.sda.onlinestoreserver.exceptions.CategoryNotFoundException;
import com.sda.onlinestoreserver.models.Category;
import com.sda.onlinestoreserver.repository.CategoryRepository;
import com.sda.onlinestoreserver.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) throws CategoryNotFoundException {
        Category category = findById(id);
        category.setActive(false);
        categoryRepository.saveAndFlush(category);
    }

    @Override
    public Category findById(Long id) throws CategoryNotFoundException {
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        if(categoryOptional.isEmpty()){
            throw new CategoryNotFoundException(id);
        }

        return categoryOptional.get();
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void updateCategory(Category category) throws CategoryNotFoundException {
        if(findById(category.getId()) != null){
            categoryRepository.saveAndFlush(category);
        }
    }
}
