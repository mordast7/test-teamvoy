package shop.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shop.model.Order;
import shop.model.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select distinct o from Order o "
            + "left join fetch o.goods "
            + "left join fetch o.user where o.user =:user")
    List<Order> findAllByUser(User user);
}
