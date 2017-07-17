package pl.salega.repository;

import org.springframework.data.repository.CrudRepository;
import pl.salega.domain.UserPayment;

/**
 * Created by kamilsalega on 16.07.2017.
 */
public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {

}
