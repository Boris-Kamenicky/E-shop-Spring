package sk.stuba.fei.uim.oop.assignment3.cart;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.payment.PaymentResponse;


import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CartResponse {
    private Long id;
    private List<PaymentResponse> shoppingList;
    private Boolean payed;

    public CartResponse (ShoppingCart a)
    {
        this.id=a.getId();
        this.shoppingList=a.getList().stream().map(PaymentResponse::new).collect(Collectors.toList());
        this.payed=a.getPayed();
    }
}