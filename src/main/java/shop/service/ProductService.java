package shop.service;

import shop.model.Product;

public interface ProductService {
    Product save(Product product);

    Product findById(Long id);
}
