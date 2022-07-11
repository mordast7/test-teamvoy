package shop.service.mapper;

import org.springframework.stereotype.Component;
import shop.dto.request.GoodsRequestDto;
import shop.dto.response.GoodsResponseDto;
import shop.dto.response.ProductResponseDto;
import shop.model.Goods;
import shop.model.Product;
import shop.service.ProductService;

@Component
public class GoodsMapper implements
        ResponseDtoMapper<GoodsResponseDto, Goods>,
        RequestDtoMapper<Goods, GoodsRequestDto> {
    private final ResponseDtoMapper<ProductResponseDto, Product> productMapper;
    private final ProductService productService;

    public GoodsMapper(ResponseDtoMapper<ProductResponseDto, Product> productMapper,
                       ProductService productService) {
        this.productMapper = productMapper;
        this.productService = productService;
    }

    @Override
    public GoodsResponseDto toDto(Goods goods) {
        GoodsResponseDto responseDto = new GoodsResponseDto();
        responseDto.setId(goods.getId());
        responseDto.setQuantity(goods.getQuantity());
        responseDto.setProductId(goods.getProduct().getId());
        return responseDto;
    }

    @Override
    public Goods toModel(GoodsRequestDto dto) {
        Goods goods = new Goods();
        goods.setQuantity(dto.getQuantity());
        goods.setProduct(productService.findById(dto.getId()));
        return goods;
    }
}
