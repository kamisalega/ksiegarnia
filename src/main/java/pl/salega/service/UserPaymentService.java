package pl.salega.service;

import pl.salega.domain.UserPayment;

/**
 * Created by kamilsalega on 16.07.2017.
 */
public interface UserPaymentService {

    UserPayment findByUserPaymentId(Long id);

    void removeByUserPaymentId(Long id);
}
