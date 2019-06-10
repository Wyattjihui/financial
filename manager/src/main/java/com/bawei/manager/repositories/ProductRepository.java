package com.bawei.manager.repositories;

import com.bawei.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Product,String>,JpaSpecificationExecutor<Product> {
}
