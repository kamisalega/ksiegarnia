package pl.salega.service;

import pl.salega.domain.Payment;
import pl.salega.domain.UserPayment;

/**
 * Created by kamilsalega on 27.07.2017.
 */
public interface PaymentService {
    Payment setByUserPayment(UserPayment userPayment, Payment payment);
}
