package pl.salega.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.salega.domain.UserShipping;

/**
 * Created by kamilsalega on 20.07.2017.
 */
@Repository
public interface UserShippingRepository extends CrudRepository<UserShipping, Long> {
}
