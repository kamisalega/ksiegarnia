package pl.salega.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import pl.salega.domain.BookToItemCart;
import pl.salega.domain.CartItem;


/**
 * Created by kamilsalega on 24.07.2017.
 */
@Transactional
public interface BookToItemCartRepository extends CrudRepository<BookToItemCart, Long> {


    void deleteByCartItem(CartItem cartItem);

}
