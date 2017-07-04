package pl.salega.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.salega.domain.User;
import pl.salega.domain.security.PasswordResetToken;
import pl.salega.service.UserService;
import pl.salega.service.impl.UserSecurityService;


/**
 * Created by kamilsalega on 21.06.2017.
 */

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    UserSecurityService userSecurityService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("classActiveLogin", true);
        return "myAccount";
    }

    @RequestMapping("/forgetPassword")
    public String forgetPassword(

            Model model) {


        model.addAttribute("classActiveForgetPassword", true);
        return "myAccount";
    }

    @RequestMapping("/newUser")
    public String newUser(Locale locale, @RequestParam("token") String token, Model model) {
        PasswordResetToken passwordToken = userService.getPasswordResetToken(token);
        if (passwordToken == null) {

            String message = "Niewazny Token";
            model.addAttribute("message", message);
            return "redirect:badRequest";
        }
        User user = passwordToken.getUser();
        String username = user.getUsername();

        UserDetails userDetails = userSecurityService.loadUserByUsername(username);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
        model.addAttribute("classActiveEdit", true);
        return "myProfile";
    }
}
