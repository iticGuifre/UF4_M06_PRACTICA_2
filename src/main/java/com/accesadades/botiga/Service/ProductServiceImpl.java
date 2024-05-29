package com.accesadades.botiga.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accesadades.botiga.Model.Product;
import com.accesadades.botiga.Repository.ProductRepository;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Set<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Set<Product> findAllProducts(String subcategory) {
        // Implement if needed
        return null;
    }

    @Override
    public void increasePrice(Product product) {
        // Implement if needed
    }

    @Override
    public void saveProduct(Product product) {
        System.out.println("Saving product: " + product);
        productRepository.save(product);
    }
}
