package sk.stuba.fei.uim.oop.assignment3.product;

import java.util.List;


public interface IProductService {
    List<Product> getAll();
    Product createNew(ProductRequest request);
    Product findById(Long id);
    Product updateDataProduct(ProductEditRequest request, Long id);
    void deleteProductById(Long id);
    ProductResponseAmount getAmount(Long id);
    ProductResponseAmount addProductAmount(ProductAmountRequest request, Long id);
}
