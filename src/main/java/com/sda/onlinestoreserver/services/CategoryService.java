package com.sda.onlinestoreserver.services;

import com.sda.onlinestoreserver.exceptions.CategoryNotFoundException;
import com.sda.onlinestoreserver.models.Category;

import java.util.List;

public interface CategoryService {
    /**
     * To create a new category
     * @param category Category
     */
    void createCategory(Category category);

    /**
     * To delete category by its id
     * @param id Category id
     */
    void deleteCategoryById(Long id) throws CategoryNotFoundException;

    /**
     * To find category by its id
     * @param id category id
     * @return category by id
     * @throws CategoryNotFoundException if no category
     */
    Category findById(Long id) throws CategoryNotFoundException;

    /**
     * To get all category
     * @return all category
     */
    List<Category> getAll();


    /**
     * To update existing category
     * @param category modified category
     */
    void updateCategory(Category category) throws CategoryNotFoundException;
}
