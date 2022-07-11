package shop.service.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import shop.dto.response.ShoppingCartResponseDto;
import shop.model.Goods;
import shop.model.ShoppingCart;

@Component
public class ShoppingCartMapper implements
        ResponseDtoMapper<ShoppingCartResponseDto, ShoppingCart> {

    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setUserId(shoppingCart.getUser().getId());
        responseDto.setGoodsId(shoppingCart.getGoods()
                .stream()
                .map(Goods::getId)
                .collect(Collectors.toList()));
        return responseDto;
    }
}
