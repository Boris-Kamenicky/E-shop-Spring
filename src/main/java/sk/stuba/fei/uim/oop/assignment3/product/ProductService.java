package sk.stuba.fei.uim.oop.assignment3.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> getAll()
    {
        return this.repository.findAll();
    }

    @Override
    public Product createNew(ProductRequest request) {
        Product newProduct = new Product();
        newProduct.setName(request.getName());
        newProduct.setDescription(request.getDescription());
        newProduct.setAmount(request.getAmount());
        newProduct.setUnit(request.getUnit());
        newProduct.setPrice(request.getPrice());
        return this.repository.save(newProduct);
    }

    @Override
    public Product findById(Long id) {
        return this.repository.findById(id).orElseThrow();
    }

    @Override
    public Product updateDataProduct(ProductEditRequest request, Long id) {
        Product productOpt = this.repository.findById(id).orElseThrow();
        Product product = productOpt;

        if (request.getName()!=null)
            product.setName(request.getName());
        if (request.getDescription()!=null)
            product.setDescription(request.getDescription());

        return this.repository.save(product);
    }

    @Override
    public void deleteProductById(Long id)
    {
        this.repository.findById(id).orElseThrow();
        this.repository.deleteById(id);
    }

    @Override
    public ProductResponseAmount getAmount(Long id) {
        Optional<Product> productOpt = this.repository.findById(id);
        Product product = productOpt.get();
        ProductResponseAmount amount = new ProductResponseAmount(product);
        return amount;
    }

    @Override
    public ProductResponseAmount addProductAmount(ProductAmountRequest request, Long id) {
        Optional<Product> productOpt = this.repository.findById(id);
        Product product = productOpt.get();
        product.setAmount(product.getAmount()+ request.getAmount());
        ProductResponseAmount amount = new ProductResponseAmount(product);
        this.repository.save(product);
        return amount;
    }
}
