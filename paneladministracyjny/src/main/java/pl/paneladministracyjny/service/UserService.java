package pl.paneladministracyjny.service;

import pl.paneladministracyjny.domain.User;
import pl.paneladministracyjny.domain.security.UserRole;

import java.util.Set;

/**
 * Created by kamilsalega on 04.07.2017.
 */
public interface UserService {


    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User save(User user);
}
