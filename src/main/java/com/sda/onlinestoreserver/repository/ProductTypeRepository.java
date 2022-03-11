package com.sda.onlinestoreserver.repository;

import com.sda.onlinestoreserver.models.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    ProductType findById(long id);
}
