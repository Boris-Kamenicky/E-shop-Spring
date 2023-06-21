package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.payment.Amount;
import sk.stuba.fei.uim.oop.assignment3.product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean payed;

    @OneToOne
    private Product product;

    @OneToMany
    private List<Amount> list = new ArrayList<>();

}