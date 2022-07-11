package shop.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dto.request.GoodsRequestDto;
import shop.dto.response.GoodsResponseDto;
import shop.model.Goods;
import shop.service.GoodsService;
import shop.service.ProductService;
import shop.service.mapper.GoodsMapper;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsService goodsService;
    private final ProductService productService;
    private final GoodsMapper mapper;

    public GoodsController(GoodsService goodsService,
                           ProductService productService,
                           GoodsMapper mapper) {
        this.goodsService = goodsService;
        this.productService = productService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<GoodsResponseDto> getAll() {
        return goodsService.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public GoodsResponseDto add(@RequestBody @Valid GoodsRequestDto requestDto) {
        Goods goods = goodsService.save(mapper.toModel(requestDto));
        return mapper.toDto(goods);
    }
}
