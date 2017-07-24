package pl.salega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.salega.domain.Book;
import pl.salega.domain.CartItem;
import pl.salega.domain.ShoppingCart;
import pl.salega.domain.User;
import pl.salega.service.BookService;
import pl.salega.service.CartItemService;
import pl.salega.service.ShoppingCartService;
import pl.salega.service.UserService;

import java.security.Principal;
import java.util.List;

/**
 * Created by kamilsalega on 22.07.2017.
 */
@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {


    @Autowired
    private UserService userService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private BookService bookService;


    @RequestMapping("/cart")
    public String shoppingCart(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        ShoppingCart shoppingCart = user.getShoppingCart();

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        shoppingCartService.updateShoppingCart(shoppingCart);

        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("shoppingCart", shoppingCart);

        return "shoppingCart";
    }

    @RequestMapping("/addItem")
    public String addItem(@ModelAttribute("book") Book book,
                          @ModelAttribute("quantity") String quantity,
                          Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        book = bookService.findOne(book.getId());

        if (Integer.parseInt(quantity) > book.getInStockNumber()) {
            model.addAttribute("notEnoughStock", true);
            return "forward:/bookDetail?id=" + book.getId();
        }

        CartItem cartItem = cartItemService.addBookToCartItem(book, user, Integer.parseInt(quantity));
        model.addAttribute("addBookSuccess", true);
        return "forward:/bookDetail?id=" + book.getId();
    }


}
