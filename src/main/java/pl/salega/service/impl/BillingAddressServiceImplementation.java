package pl.salega.service.impl;

import org.springframework.stereotype.Service;
import pl.salega.domain.BillingAddress;
import pl.salega.domain.UserBilling;
import pl.salega.service.BillingAddressService;

/**
 * Created by kamilsalega on 27.07.2017.
 */
@Service
public class BillingAddressServiceImplementation implements BillingAddressService {

    @Override
    public BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress) {
        billingAddress.setBillingAddressName(userBilling.getUserBillingName());
        billingAddress.setBillingAddressStreet1(userBilling.getUserBillingStreet1());
        billingAddress.setBillingAddressStreet2(userBilling.getUserBillingStreet2());
        billingAddress.setBillingAddressCity(userBilling.getUserBillingCity());
        billingAddress.setBillingAddressVoivodeships(userBilling.getUserBillingVoivodeships());
        billingAddress.setBillingAddressCountry(userBilling.getUserBillingCountry());
        billingAddress.setBillingAddressPostcode(userBilling.getUserBillingPostcode());
        return billingAddress;
    }

}
