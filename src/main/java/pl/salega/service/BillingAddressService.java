package pl.salega.service;

import pl.salega.domain.BillingAddress;
import pl.salega.domain.UserBilling;

/**
 * Created by kamilsalega on 27.07.2017.
 */
public interface BillingAddressService {

    BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);

}
