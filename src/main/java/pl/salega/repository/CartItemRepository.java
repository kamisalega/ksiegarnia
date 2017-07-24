package pl.salega.repository;

import org.springframework.data.repository.CrudRepository;
import pl.salega.domain.CartItem;
import pl.salega.domain.ShoppingCart;

import java.util.List;

/**
 * Created by kamilsalega on 22.07.2017.
 */
public interface CartItemRepository extends CrudRepository<CartItem, Long> {

    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
}
