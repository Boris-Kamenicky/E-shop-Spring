package sk.stuba.fei.uim.oop.assignment3.payment;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class PaymentResponse {

    private Long productId;
    private int amount;

    public PaymentResponse(Amount a) {
        this.productId = a.getProduct().getId();
        this.amount = a.getAmount();
    }
}

