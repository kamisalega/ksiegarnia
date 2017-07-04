package pl.salega.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.salega.domain.User;
import pl.salega.domain.security.PasswordResetToken;
import pl.salega.repository.PasswordResetTokenRepository;
import pl.salega.service.UserService;

/**
 * Created by kamilsalega on 04.07.2017.
 */
public class UserServiceImplementation implements UserService {

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Override
    public PasswordResetToken getPasswordResetToken(final String token) {
        return passwordResetTokenRepository.findByToken(token);
    }

    @Override
    public void createPasswordResetTokenForUser(final User user, final String token) {

        final PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordResetTokenRepository.save(myToken);

    }
}
