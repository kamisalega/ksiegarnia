package pl.salega.service;

import pl.salega.domain.*;

/**
 * Created by kamilsalega on 28.07.2017.
 */
public interface OrderService {

    Order createOrder(ShoppingCart shoppingCart,
                      ShippingAddress shippingAddress,
                      BillingAddress billingAddress, Payment payment, String shippingMethod, User user);

    Order findOneOrder(Long id);
}
