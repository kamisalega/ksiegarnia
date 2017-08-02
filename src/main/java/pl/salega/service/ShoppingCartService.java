package pl.salega.service;

import pl.salega.domain.ShoppingCart;

/**
 * Created by kamilsalega on 22.07.2017.
 */
public interface ShoppingCartService {

    ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);

    void clearShoppingCart(ShoppingCart shoppingCart);
}
