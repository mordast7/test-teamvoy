package shop.service.mapper;

import org.springframework.stereotype.Component;
import shop.dto.request.ProductRequestDto;
import shop.dto.response.ProductResponseDto;
import shop.model.Product;

@Component
public class ProductMapper implements
        ResponseDtoMapper<ProductResponseDto, Product>,
        RequestDtoMapper<Product, ProductRequestDto> {
    @Override
    public ProductResponseDto toDto(Product product) {
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setId(product.getId());
        responseDto.setName(product.getName());
        responseDto.setPrice(product.getPrice());
        return responseDto;
    }

    @Override
    public Product toModel(ProductRequestDto dto) {
        Product product = new Product();
        product.setPrice(dto.getPrice());
        product.setName(dto.getName());
        return product;
    }
}
