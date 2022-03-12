package com.sda.onlinestoreserver.services;

import com.sda.onlinestoreserver.exceptions.OrderLineNotFoundException;
import com.sda.onlinestoreserver.exceptions.ProductNotFoundException;
import com.sda.onlinestoreserver.models.Product;

import java.util.List;

public interface ProductService {
    /**
     * To create a new product
     *
     * @param product Product
     */
    void createProduct(Product product);

    /**
     * To delete product by its id
     *
     * @param id Product id
     */
    void deleteProductById(Long id) throws ProductNotFoundException;

    /**
     * To restore product by its id
     * @param id of the product
     * @throws ProductNotFoundException if no product
     */
    void restoreProductById(Long id) throws ProductNotFoundException;

    /**
     * To find product by its id
     *
     * @param id product id
     * @return product by id
     * @throws ProductNotFoundException if no product
     */
    Product findById(Long id) throws ProductNotFoundException;

    /**
     * To get all product
     *
     * @return all product
     */
    List<Product> getAll();


    /**
     * To update existing product
     *
     * @param product modified product
     */
    void updateProduct(Product product) throws ProductNotFoundException;
}
