package sk.stuba.fei.uim.oop.assignment3.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping("/product")
    public List<ProductResponse> getAllProducts()
    {
        return this.service.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());  // musis zmenit kazdy object Product na ProductResponse
    }

    @PostMapping("/product")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest request)
    {
        return new ResponseEntity<>(new ProductResponse(this.service.createNew(request)), HttpStatus.CREATED);
    }

    @GetMapping("/product/{id}")
    public ProductResponse getProductById(@PathVariable("id") Long id)
    {
        return new ProductResponse(this.service.findById(id));  // musis zmenit kazdy object Product na ProductResponse
    }

    @PutMapping("/product/{id}")
    public ProductResponse updateDataProduct(@PathVariable("id") Long id, @RequestBody ProductEditRequest request)
    {
        return  new ProductResponse(this.service.updateDataProduct(request,id));
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") Long id)
    {
        this.service.deleteProductById(id);
    }

    @GetMapping("/product/{id}/amount")
    public ProductResponseAmount getProductAmount(@PathVariable("id") Long id)
    {
        return this.service.getAmount(id);
    }

    @PostMapping("/product/{id}/amount")
    public ProductResponseAmount addProductAmount(@PathVariable("id") Long id,@RequestBody ProductAmountRequest request)  //request body asi vytvorit novy objekt
    {
        return this.service.addProductAmount(request,id);
    }

}
