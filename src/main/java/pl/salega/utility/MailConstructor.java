package pl.salega.utility;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import pl.salega.domain.User;

import java.util.Locale;

/**
 * Created by kamilsalega on 05.07.2017.
 */
@Component
public class MailConstructor {

    @Autowired
    private Environment environment;


    public SimpleMailMessage constructorResetTokenEmail(String contextPath, Locale locale, String token, User user, String password) {
        String url = contextPath + "/newUser?token=" + token;

        String message = "\n Proszę klikąć na ten link aby zweyfikować email i edytować personalne informacje." +
                " Twoje hasło to: \n" + password;
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("Księgarnia Sałęga - Nowy użytkownik");
        email.setText(url + message);
        email.setFrom(environment.getProperty("support.email"));
        return email;

    }
}
