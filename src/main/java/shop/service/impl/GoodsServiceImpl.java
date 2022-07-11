package shop.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import shop.model.Goods;
import shop.repository.GoodsRepository;
import shop.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
    private final GoodsRepository goodsRepository;

    public GoodsServiceImpl(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public Goods save(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public Goods findByProductId(Long productId) {
        return goodsRepository.findById(productId).get();
    }

    @Override
    public List<Goods> findAll() {
        return goodsRepository.findAll();
    }
}
