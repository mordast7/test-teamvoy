package shop.service;

import java.util.List;
import shop.model.Goods;

public interface GoodsService {
    Goods save(Goods goods);

    Goods findByProductId(Long productId);

    List<Goods> findAll();
}
