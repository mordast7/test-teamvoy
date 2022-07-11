package shop.service.mapper;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import shop.dto.response.OrderResponseDto;
import shop.model.Goods;
import shop.model.Order;

@Component
public class OrderMapper implements
        ResponseDtoMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setGoodsIds(order.getGoods().stream()
                .map(Goods::getId)
                .collect(Collectors.toList()));
        responseDto.setUserId(order.getUser().getId());
        responseDto.setOrderTime(order.getOrderTime());
        return responseDto;
    }
}
