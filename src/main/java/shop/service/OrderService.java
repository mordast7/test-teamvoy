package shop.service;

import java.util.List;
import shop.model.Order;
import shop.model.ShoppingCart;
import shop.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> findAllByUser(User user);
}
