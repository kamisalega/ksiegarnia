package pl.salega.repository;

import org.springframework.data.repository.CrudRepository;
import pl.salega.domain.BookToItemCart;

/**
 * Created by kamilsalega on 24.07.2017.
 */
public interface BookToItemCartRepository extends CrudRepository<BookToItemCart, Long> {
}
