package com.sda.onlinestoreserver.services.implementations;

import com.sda.onlinestoreserver.exceptions.ProductTypeNotFoundException;
import com.sda.onlinestoreserver.models.ProductType;
import com.sda.onlinestoreserver.repository.ProductTypeRepository;
import com.sda.onlinestoreserver.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public void createProductType(ProductType productType) {
        productTypeRepository.save(productType);
    }

    @Override
    public void deleteProductTypeById(Long id) throws ProductTypeNotFoundException {
        ProductType productType = findById(id);
        productType.setActive(false);
        productTypeRepository.saveAndFlush(productType);
    }

    @Override
    public ProductType findById(Long id) throws ProductTypeNotFoundException {
        Optional<ProductType> optionalProductType = productTypeRepository.findById(id);

        if (optionalProductType.isEmpty()) {
            throw new ProductTypeNotFoundException(id);
        }

        return optionalProductType.get();
    }

    @Override
    public List<ProductType> getAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public void updateProductType(ProductType productType) throws ProductTypeNotFoundException {
        if (findById(productType.getId()) != null){
            productTypeRepository.saveAndFlush(productType);
        }
    }
}
