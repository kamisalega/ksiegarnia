package pl.salega.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.salega.domain.User;
import pl.salega.domain.security.PasswordResetToken;

import java.util.Date;
import java.util.stream.Stream;

/**
 * Created by kamilsalega on 04.07.2017.
 */
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    PasswordResetToken findByToken(String token);

    PasswordResetToken findByUser(User user);

    Stream<PasswordResetToken> findAllByExpiryDateLessThan(Date now);

    @Modifying
    @Query("delete from PasswordResetToken t where t <= ?1")
    void deleteAllExpiredSince(Date now);

}
