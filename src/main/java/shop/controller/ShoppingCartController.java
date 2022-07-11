package shop.controller;

import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.dto.request.GoodsRequestDto;
import shop.dto.response.ShoppingCartResponseDto;
import shop.model.Goods;
import shop.model.User;
import shop.service.ShoppingCartService;
import shop.service.UserService;
import shop.service.mapper.GoodsMapper;
import shop.service.mapper.ShoppingCartMapper;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final UserService userService;
    private final ShoppingCartMapper shoppingCartMapper;
    private final GoodsMapper goodsMapper;
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(UserService userService,
                                  ShoppingCartMapper shoppingCartMapper,
                                  GoodsMapper goodsMapper,
                                  ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.goodsMapper = goodsMapper;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(Authentication authentication) {
        User user = userService.findUserByEmail(authentication.getName()).orElseThrow(
                () -> new RuntimeException("User with email "
                        + authentication.getName() + " not found"));
        return shoppingCartMapper.toDto(shoppingCartService.findByUser(user));
    }

    @PutMapping("/goods")
    public void addProduct(Authentication authentication,
                           @RequestBody @Valid GoodsRequestDto goodsRequestDto) {
        Goods goods = goodsMapper.toModel(goodsRequestDto);
        shoppingCartService.addGoods(goods, userService.findUserByEmail(authentication.getName())
                .orElseThrow(() -> new RuntimeException("User with email "
                        + authentication.getName() + " not found")));
    }
}
