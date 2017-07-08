package pl.paneladministracyjny.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.paneladministracyjny.domain.User;
import pl.paneladministracyjny.domain.security.UserRole;
import pl.paneladministracyjny.repository.RoleRepository;
import pl.paneladministracyjny.repository.UserRepository;
import pl.paneladministracyjny.service.UserService;

import java.util.Set;


/**
 * Created by kamilsalega on 04.07.2017.
 */
@Service
public class UserServiceImplementation implements UserService {


    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public User createUser(User user, Set<UserRole> userRoles) {
        User localUser = userRepository.findByUsername(user.getUsername());
        if (localUser != null) {
            LOG.info("Użytkownik już istnieje. Nic nie zostanie zrobione", user.getUsername());
        } else {
            for (UserRole userRole : userRoles) {
                roleRepository.save(userRole.getRole());
            }

            user.getUserRoles().addAll(userRoles);
            localUser = userRepository.save(user);
        }
        return localUser;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


}
