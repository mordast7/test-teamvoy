package shop.service.impl;

import org.springframework.stereotype.Service;
import shop.model.Product;
import shop.repository.ProductRepository;
import shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }
}
