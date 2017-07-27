package pl.salega.service;

import pl.salega.domain.ShippingAddress;
import pl.salega.domain.UserShipping;

/**
 * Created by kamilsalega on 27.07.2017.
 */

public interface ShippingAddressService {

    ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);

}
