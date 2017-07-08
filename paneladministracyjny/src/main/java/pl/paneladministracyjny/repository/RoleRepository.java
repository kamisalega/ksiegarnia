package pl.paneladministracyjny.repository;

import org.springframework.data.repository.CrudRepository;
import pl.paneladministracyjny.domain.security.Role;

/**
 * Created by kamilsalega on 05.07.2017.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByname(String name);
}
