package shop.service;

import java.util.List;
import shop.model.Goods;
import shop.model.ShoppingCart;
import shop.model.User;

public interface ShoppingCartService {
    ShoppingCart save(ShoppingCart shoppingCart);

    List<ShoppingCart> findAll();

    ShoppingCart findByUser(User user);

    void createShoppingCart(User user);

    void addGoods(Goods goods, User user);

    List<ShoppingCart> findAllByTimeIsLessThen(Long timeCreated);

    void clear(ShoppingCart shoppingCart);
}
