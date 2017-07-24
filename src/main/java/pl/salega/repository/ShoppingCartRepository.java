package pl.salega.repository;

import org.springframework.data.repository.CrudRepository;
import pl.salega.domain.ShoppingCart;

/**
 * Created by kamilsalega on 22.07.2017.
 */
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
