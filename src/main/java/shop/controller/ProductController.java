package shop.controller;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dto.request.ProductRequestDto;
import shop.dto.response.ProductResponseDto;
import shop.model.Product;
import shop.service.ProductService;
import shop.service.mapper.RequestDtoMapper;
import shop.service.mapper.ResponseDtoMapper;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final RequestDtoMapper<Product, ProductRequestDto> requestMapper;
    private final ResponseDtoMapper<ProductResponseDto, Product> responseMapper;

    public ProductController(ProductService productService,
                             RequestDtoMapper<Product, ProductRequestDto> requestMapper,
                             ResponseDtoMapper<ProductResponseDto, Product> responseMapper) {
        this.productService = productService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping
    public ProductResponseDto add(@RequestBody @Valid ProductRequestDto requestDto) {
        Product product = productService.save(requestMapper.toModel(requestDto));
        return responseMapper.toDto(product);
    }
}
