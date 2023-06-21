package sk.stuba.fei.uim.oop.assignment3.cart;


public interface IShoppingCartService {
    ShoppingCart createNew();
    ShoppingCart findById(Long id);
    void deleteCartById(Long id);
    ShoppingCart addProductToCart(Long id, ProductAddRequest request);
    String payForCart(Long id);
}
