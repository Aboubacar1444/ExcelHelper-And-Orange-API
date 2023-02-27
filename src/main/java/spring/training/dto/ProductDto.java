package spring.training.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Getter
@Setter
public class ProductDto implements Serializable {
    private final String ref;
    private final BigDecimal prix;
    private final double quantityStock;
}
