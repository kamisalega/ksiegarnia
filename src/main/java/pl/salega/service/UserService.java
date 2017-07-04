package pl.salega.service;

import pl.salega.domain.User;
import pl.salega.domain.security.PasswordResetToken;

/**
 * Created by kamilsalega on 04.07.2017.
 */
public interface UserService {

    PasswordResetToken getPasswordResetToken(final String token);

    void createPasswordResetTokenForUser(final User user, final String token);
}
