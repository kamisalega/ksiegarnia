package pl.salega.service;

import pl.salega.domain.Book;
import pl.salega.domain.CartItem;
import pl.salega.domain.ShoppingCart;
import pl.salega.domain.User;

import java.util.List;

/**
 * Created by kamilsalega on 22.07.2017.
 */
public interface CartItemService {

    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

    CartItem updateCartItem(CartItem cartItem);

    CartItem addBookToCartItem(Book book, User user, int quantity);

    CartItem findById(Long id);

    void removeCartItem(CartItem cartItem);

}
