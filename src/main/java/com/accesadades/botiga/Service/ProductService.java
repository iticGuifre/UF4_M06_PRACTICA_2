package com.accesadades.botiga.Service;

import java.util.Set;
import com.accesadades.botiga.Model.Product;

public interface ProductService {
    Set<Product> findAllProducts();
    Product findProductsByName(String name);
    void saveProduct(Product product);
}
