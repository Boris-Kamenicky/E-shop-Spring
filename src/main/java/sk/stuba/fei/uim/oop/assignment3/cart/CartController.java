package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CartController {

    @Autowired
    private IShoppingCartService service;


    @PostMapping("/cart")
    public ResponseEntity<CartResponse> addCart()
    {
        return new ResponseEntity<>(new CartResponse(this.service.createNew()),HttpStatus.CREATED);
    }

    @GetMapping("/cart/{id}")
    public CartResponse getCart(@PathVariable ("id")Long id)
    {
        return new CartResponse(this.service.findById(id));
    }

    @DeleteMapping("/cart/{id}")
    public void deleteCart(@PathVariable ("id") Long id)
    {
        this.service.deleteCartById(id);
    }

    @PostMapping("/cart/{id}/add")
    public CartResponse addProductToCart(@PathVariable ("id") Long id, @RequestBody ProductAddRequest request)
    {
        return new CartResponse(this.service.addProductToCart(id,request));
    }

    @GetMapping("/cart/{id}/pay")
    public String payForCart(@PathVariable ("id") Long id)
    {
        return this.service.payForCart(id);
    }

}