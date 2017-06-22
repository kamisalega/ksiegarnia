package pl.salega.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kamilsalega on 21.06.2017.
 */

@Controller
public class GlownyController {

    @RequestMapping("/")
    public String index() {
    return "index";
    }

    @RequestMapping("/mojeKonto")
    public String mojeKonto() {
        return "mojeKonto";
    }



}
