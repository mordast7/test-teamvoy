package shop.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GoodsRequestDto {
    @NotNull
    private Long id;
    @Min(0)
    private Long quantity;
}
