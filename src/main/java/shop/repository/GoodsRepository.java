package shop.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shop.model.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
    @Query("select g from Goods g where g.product.id = :id and g.existAtShoppingCart = false")
    Optional<Goods> findByProductId(Long id);
}
