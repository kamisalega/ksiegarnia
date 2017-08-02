package pl.salega.repository;

import org.springframework.data.repository.CrudRepository;
import pl.salega.domain.Order;

/**
 * Created by kamilsalega on 28.07.2017.
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
}
