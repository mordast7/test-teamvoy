package shop.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class ShoppingCartResponseDto {
    private Long userId;
    private List<Long> goodsId;
}
