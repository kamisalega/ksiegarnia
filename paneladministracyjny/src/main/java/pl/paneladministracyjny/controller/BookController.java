package pl.paneladministracyjny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.paneladministracyjny.domain.Book;


/**
 * Created by kamilsalega on 07.07.2017.
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping("/add")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "addBook";
    }
}
