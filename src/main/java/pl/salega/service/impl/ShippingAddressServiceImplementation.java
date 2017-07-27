package pl.salega.service.impl;

import org.springframework.stereotype.Service;
import pl.salega.domain.ShippingAddress;
import pl.salega.domain.UserShipping;
import pl.salega.service.ShippingAddressService;

/**
 * Created by kamilsalega on 27.07.2017.
 */
@Service
public class ShippingAddressServiceImplementation implements ShippingAddressService {
    @Override
    public ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress) {

        shippingAddress.setShippingAddressName(userShipping.getUserShippingName());
        shippingAddress.setShippingAddressStreet1(userShipping.getUserShippingStreet1());
        shippingAddress.setShippingAddressStreet2(userShipping.getUserShippingStreet2());
        shippingAddress.setShippingAddressCity(userShipping.getUserShippingCity());
        shippingAddress.setShippingAddressVoivodeships(userShipping.getUserShippingVoivodeships());
        shippingAddress.setShippingAddressCountry(userShipping.getUserShippingCountry());
        shippingAddress.setShippingAddressPostcode(userShipping.getUserShippingPostcode());
        return shippingAddress;
    }
}
