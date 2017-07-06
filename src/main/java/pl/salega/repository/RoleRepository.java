package pl.salega.repository;

import org.springframework.data.repository.CrudRepository;
import pl.salega.domain.security.Role;

/**
 * Created by kamilsalega on 05.07.2017.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByname(String name);
}
