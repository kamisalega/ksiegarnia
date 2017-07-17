package pl.salega.service;

import pl.salega.domain.User;
import pl.salega.domain.UserBilling;
import pl.salega.domain.UserPayment;
import pl.salega.domain.security.PasswordResetToken;
import pl.salega.domain.security.UserRole;

import java.util.Set;

/**
 * Created by kamilsalega on 04.07.2017.
 */
public interface UserService {

    PasswordResetToken getPasswordResetToken(final String token);

    void createPasswordResetTokenForUser(final User user, final String token);

    User findByUsername(String username);

    User findByEmail(String email);

    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User save(User user);

    void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);

    void setUserDefaultPayment(Long userPaymentId, User user);
}
