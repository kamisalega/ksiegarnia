package pl.salega.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import pl.salega.domain.CartItem;
import pl.salega.domain.Order;
import pl.salega.domain.ShoppingCart;

import java.util.List;

/**
 * Created by kamilsalega on 22.07.2017.
 */
@Transactional
public interface CartItemRepository extends CrudRepository<CartItem, Long> {

    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

    List<CartItem> findByOrder(Order order);
}
