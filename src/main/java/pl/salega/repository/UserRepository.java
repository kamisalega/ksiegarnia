package pl.salega.repository;


import org.springframework.data.repository.CrudRepository;
import pl.salega.domain.User;

/**
 * Created by kamilsalega on 03.07.2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
