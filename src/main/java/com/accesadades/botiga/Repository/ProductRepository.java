package com.accesadades.botiga.Repository;

import org.springframework.data.repository.CrudRepository;
import com.accesadades.botiga.Model.Product;

import java.util.Set;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Set<Product> findAll();
    Product findByName(String name);
}