package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exceptions.CartException;
import sk.stuba.fei.uim.oop.assignment3.payment.Amount;
import sk.stuba.fei.uim.oop.assignment3.payment.AmountRepository;
import sk.stuba.fei.uim.oop.assignment3.product.IProductService;
import sk.stuba.fei.uim.oop.assignment3.product.Product;

@Service
public class ShoppingCartService implements IShoppingCartService{

    @Autowired
    private IProductService productService;

    @Autowired
    private CartRepository repository;

    @Autowired
    private AmountRepository amountRepository;

    @Override
    public ShoppingCart createNew()
    {
        ShoppingCart cart= new ShoppingCart();
        cart.setPayed(false);


        return this.repository.save(cart);
    }

    @Override
    public ShoppingCart findById(Long id)
    {
        return this.repository.findById(id).orElseThrow();
    }

    @Override
    public void deleteCartById(Long id)
    {

        this.repository.findById(id).orElseThrow();
        this.repository.deleteById(id);

    }

    @Override
    public ShoppingCart addProductToCart(Long id, ProductAddRequest request)
    {
        boolean isPresent=false;
        ShoppingCart cart = this.repository.findById(id).orElseThrow();

        Product product = this.productService.findById(request.getProductId());
        if(product.getAmount()< request.getAmount() || cart.getPayed())
        {
            //hod vynimku 400
            throw  new CartException();
        }

        for (Amount d : cart.getList()) {
            if (d.getProduct().getId().equals(request.getProductId())) {
                d.setAmount(d.getAmount() + request.getAmount());
                isPresent=true;
                product.setAmount(product.getAmount()- request.getAmount());
                break ;
            }
        }
        if(!isPresent)
        {
            Amount amount = new Amount(product,cart, request.getAmount());
            amount = this.amountRepository.save(amount);
            product.setAmount(product.getAmount()- request.getAmount());
            cart.getList().add(amount);
        }

        return this.repository.save(cart);
    }

    @Override
    public String payForCart(Long id) {
        int sum=0;
        ShoppingCart cart=this.repository.findById(id).orElseThrow();
        if(cart.getPayed())
        {
            throw new CartException();
        }
        cart.setPayed(true);

        for (Amount d : cart.getList()) {
            sum=sum+(d.getProduct().getPrice())*d.getAmount();
        }
        this.repository.save(cart);
        return String.valueOf(sum);
    }


}
