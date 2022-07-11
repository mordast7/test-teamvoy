package shop.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import shop.model.Order;
import shop.model.ShoppingCart;
import shop.model.User;
import shop.repository.OrderRepository;
import shop.service.GoodsService;
import shop.service.OrderService;
import shop.service.ShoppingCartService;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;
    private final GoodsService goodsService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            ShoppingCartService shoppingCartService,
                            GoodsService goodsService) {
        this.orderRepository = orderRepository;
        this.shoppingCartService = shoppingCartService;
        this.goodsService = goodsService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        return null;
    }

    @Override
    public List<Order> findAllByUser(User user) {
        return null;
    }
}
