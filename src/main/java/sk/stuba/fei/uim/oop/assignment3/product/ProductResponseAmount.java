package sk.stuba.fei.uim.oop.assignment3.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseAmount {
    private Integer amount;

    public ProductResponseAmount (Product a)
    {
        this.amount=a.getAmount();
    }
}