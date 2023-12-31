package sk.stuba.fei.uim.oop.assignment3.product;

import lombok.Getter;

@Getter
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Integer amount;
    private String unit;
    private Integer price;

    public ProductResponse (Product a)
    {
        this.id=a.getId();
        this.name=a.getName();
        this.description=a.getDescription();
        this.amount=a.getAmount();
        this.unit=a.getUnit();
        this.price=a.getPrice();
    }
}
