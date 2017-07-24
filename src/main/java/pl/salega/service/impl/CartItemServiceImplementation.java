package pl.salega.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.salega.domain.*;
import pl.salega.repository.BookToItemCartRepository;
import pl.salega.repository.CartItemRepository;
import pl.salega.service.CartItemService;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kamilsalega on 22.07.2017.
 */
@Service
public class CartItemServiceImplementation implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private BookToItemCartRepository bookToItemCartRepository;

    @Override
    public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
        return cartItemRepository.findByShoppingCart(shoppingCart);

    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {

        BigDecimal bigDecimal = new BigDecimal(cartItem.getBook().getOurPrice()).multiply(new BigDecimal(cartItem.getQuantity()));
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        cartItem.setSubtotal(bigDecimal);

        cartItemRepository.save(cartItem);

        return cartItem;

    }

    @Override
    public CartItem addBookToCartItem(Book book, User user, int quantity) {
        List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());

        for (CartItem cartItem : cartItemList) {
            if (book.getId() == cartItem.getBook().getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                cartItem.setSubtotal(new BigDecimal(book.getOurPrice()).multiply(new BigDecimal(quantity)));
                cartItemRepository.save(cartItem);
                return cartItem;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setShoppingCart(user.getShoppingCart());
        cartItem.setBook(book);
        cartItem.setQuantity(quantity);
        cartItem.setSubtotal(new BigDecimal(book.getOurPrice()).multiply(new BigDecimal(quantity)));
        cartItem = cartItemRepository.save(cartItem);

        BookToItemCart bookToItemCart = new BookToItemCart();
        bookToItemCart.setBook(book);
        bookToItemCart.setCartItem(cartItem);
        bookToItemCartRepository.save(bookToItemCart);
        return cartItem;
    }
}
