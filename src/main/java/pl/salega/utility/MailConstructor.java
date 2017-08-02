package pl.salega.utility;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.salega.domain.Order;
import pl.salega.domain.User;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Locale;

/**
 * Created by kamilsalega on 05.07.2017.
 */
@Component
public class MailConstructor {

    @Autowired
    private Environment environment;


    @Autowired
    private TemplateEngine templateEngine;

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

    public MimeMessagePreparator constructOrderConfirmationEmail(User user, Order order, Locale locale) {
        Context context = new Context();

        context.setVariable("order", order);
        context.setVariable("user", user);

        context.setVariable("cartItemList", order.getCartItemList());

        String text = templateEngine.process("orderConfirmationEmailTemplate", context);


        MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
                email.setTo(user.getEmail());
                email.setSubject("Potwierdzenie zamówienia - " + order.getId());
                email.setText(text, true);
                email.setFrom(new InternetAddress("kamilsalega@gmail.com"));

            }

        };

        return messagePreparator;
    }
}
