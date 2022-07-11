package shop.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import shop.model.ShoppingCart;
import shop.model.User;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart findByUser(User user);

    List<ShoppingCart> findAllByTimeCreatedIsLessThan(Long timeCreated);
}
