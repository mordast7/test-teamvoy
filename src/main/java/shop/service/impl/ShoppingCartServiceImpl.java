package shop.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import shop.model.Goods;
import shop.model.ShoppingCart;
import shop.model.User;
import shop.repository.ShoppingCartRepository;
import shop.service.GoodsService;
import shop.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final GoodsService goodsService;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   GoodsService goodsService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.goodsService = goodsService;
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public List<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public ShoppingCart findByUser(User user) {
        return shoppingCartRepository.findByUser(user);
    }

    @Override
    public void createShoppingCart(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCart.setTimeCreated(System.currentTimeMillis());
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void addGoods(Goods goods, User user) {
        if (goods.getQuantity() > goodsService
                .findByProductId(goods.getProduct().getId()).getQuantity()) {
            throw new RuntimeException("Invalid quantity");
        }
        ShoppingCart shoppingCart = shoppingCartRepository.findByUser(user);
        goods.setExistAtShoppingCart(true);
        goodsService.save(goods);
        shoppingCart.getGoods().add(goods);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public List<ShoppingCart> findAllByTimeIsLessThen(Long timeCreated) {
        return shoppingCartRepository.findAllByTimeCreatedIsLessThan(timeCreated);
    }

    @Override
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.setGoods(null);
        shoppingCartRepository.save(shoppingCart);
    }
}
