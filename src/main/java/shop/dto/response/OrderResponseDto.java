package shop.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private List<Long> goodsIds;
    private LocalDateTime orderTime;
    private Long userId;
}
