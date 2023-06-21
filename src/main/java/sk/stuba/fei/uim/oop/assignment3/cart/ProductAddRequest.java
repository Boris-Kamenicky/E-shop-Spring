package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductAddRequest {
    private Long productId;
    private Integer amount;
}