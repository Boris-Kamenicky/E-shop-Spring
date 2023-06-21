package sk.stuba.fei.uim.oop.assignment3.payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.ShoppingCart;
import sk.stuba.fei.uim.oop.assignment3.product.Product;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Amount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Product product;
    @ManyToOne
    private ShoppingCart cart;

    private int amount;

    public Amount(Product product, ShoppingCart cart, int amount) {
        this.product = product;
        this.cart = cart;
        this.amount = amount;
    }
}
