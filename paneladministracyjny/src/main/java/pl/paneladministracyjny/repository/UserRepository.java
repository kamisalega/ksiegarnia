package pl.paneladministracyjny.repository;

import org.springframework.data.repository.CrudRepository;
import pl.paneladministracyjny.domain.User;

/**
 * Created by kamilsalega on 07.07.2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
