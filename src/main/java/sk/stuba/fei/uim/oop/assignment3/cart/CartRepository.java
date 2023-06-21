package sk.stuba.fei.uim.oop.assignment3.cart;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartRepository extends CrudRepository<ShoppingCart,Long> {
    Optional<ShoppingCart> findById(Long id);
}
