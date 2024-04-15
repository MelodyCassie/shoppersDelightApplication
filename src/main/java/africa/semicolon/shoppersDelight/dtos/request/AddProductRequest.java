package africa.semicolon.shoppersDelight.dtos.request;

import africa.semicolon.shoppersDelight.models.Category;
import africa.semicolon.shoppersDelight.models.Store;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AddProductRequest {
    private Long id;
    private String name;
    private BigDecimal price;
    private String description;
    private Integer quantity;
    private String category;

}
