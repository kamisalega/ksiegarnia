package pl.salega.service.impl;

import org.springframework.stereotype.Service;
import pl.salega.domain.Payment;
import pl.salega.domain.UserPayment;
import pl.salega.service.PaymentService;

/**
 * Created by kamilsalega on 27.07.2017.
 */
@Service
public class PaymentServiceImplementation implements PaymentService {
    @Override
    public Payment setByUserPayment(UserPayment userPayment, Payment payment) {
        payment.setType(userPayment.getType());
        payment.setHolderName(userPayment.getHolderName());
        payment.setCardNumber(userPayment.getCardNumber());
        payment.setExpiryMonth(userPayment.getExpiryMonth());
        payment.setExpiryYear(userPayment.getExpiryYear());
        payment.setCvc(userPayment.getCvc());


        return payment;
    }
}
