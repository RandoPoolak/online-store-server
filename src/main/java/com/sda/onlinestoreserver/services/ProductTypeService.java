package com.sda.onlinestoreserver.services;

import com.sda.onlinestoreserver.exceptions.ProductTypeNotFoundException;
import com.sda.onlinestoreserver.models.ProductType;

import java.util.List;

public interface ProductTypeService {
    /**
     * To create a new productType
     *
     * @param productType ProductType
     */
    void createProductType(ProductType productType);

    /**
     * To delete productType by its id
     *
     * @param id ProductType id
     */
    void deleteProductTypeById(Long id) throws ProductTypeNotFoundException;

    /**
     * To find productType by its id
     *
     * @param id productType id
     * @return productType by id
     * @throws ProductTypeNotFoundException if no productType
     */
    ProductType findById(Long id) throws ProductTypeNotFoundException;

    /**
     * To get all productTypes
     *
     * @return all productTypes
     */
    List<ProductType> getAll();


    /**
     * To update existing productType
     *
     * @param productType modified productType
     */
    void updateProductType(ProductType productType) throws ProductTypeNotFoundException;
}
