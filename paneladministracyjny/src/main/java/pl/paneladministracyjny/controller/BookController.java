package pl.paneladministracyjny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.paneladministracyjny.domain.Book;
import pl.paneladministracyjny.service.BookService;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


/**
 * Created by kamilsalega on 07.07.2017.
 */
@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "addBook";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
        bookService.save(book);
        MultipartFile bookImage = book.getBookImage();
        try {
            byte[] bytes = bookImage.getBytes();
            String nameImg = book.getId() + ".png";
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                    new File("paneladministracyjny/src/main/resources/static/image/book/" + nameImg)));
            stream.write(bytes);
            stream.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:bookList";
    }

    @RequestMapping("/bookInfo")
    public String bookInfo(@RequestParam("id") Long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        return "bookInfo";

    }

    @RequestMapping("/updateBook")
    public String updateBook(@RequestParam("id") Long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        return "updateBook";
    }

    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public String updateBookPost(@ModelAttribute("book") Book book, HttpServletRequest request) {
        bookService.save(book);

        MultipartFile bookImage = book.getBookImage();


        if (!bookImage.isEmpty()) {
            try {
                byte[] bytes = bookImage.getBytes();
                String nameImg = book.getId() + ".png";
                Files.delete(Paths.get("paneladministracyjny/src/main/resources/static/image/book/" + nameImg));
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                        new File("paneladministracyjny/src/main/resources/static/image/book/" + nameImg)));
                stream.write(bytes);
                stream.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return "redirect:/book/bookInfo?id=" + book.getId();


    }


    @RequestMapping("/bookList")
    public String bookList(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList", bookList);

        return "bookList";
    }
}
