package com.sda.onlinestoreserver.services.implementations;

import com.sda.onlinestoreserver.exceptions.ProductNotFoundException;
import com.sda.onlinestoreserver.models.Product;
import com.sda.onlinestoreserver.repository.ProductRepository;
import com.sda.onlinestoreserver.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) throws ProductNotFoundException {
        Product product = findById(id);
        product.setActive(false);
        productRepository.saveAndFlush(product);
    }

    @Override
    public void restoreProductById(Long id) throws ProductNotFoundException {
        Product product = findById(id);
        product.setActive(true);
        productRepository.saveAndFlush(product);
    }

    @Override
    public Product findById(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()){
            throw new ProductNotFoundException(id);
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void updateProduct(Product product) throws ProductNotFoundException {
        if(findById(product.getId()) != null){
            productRepository.saveAndFlush(product);
        }
    }
}
