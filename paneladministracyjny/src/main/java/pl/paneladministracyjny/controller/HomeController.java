package pl.paneladministracyjny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kamilsalega on 06.07.2017.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }


    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
