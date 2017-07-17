package pl.salega.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.salega.domain.UserPayment;
import pl.salega.repository.UserPaymentRepository;
import pl.salega.service.UserPaymentService;

/**
 * Created by kamilsalega on 16.07.2017.
 */
@Service
public class UserPaymentServiceImplementation implements UserPaymentService {

    @Autowired
    UserPaymentRepository userPaymentRepository;

    @Override
    public UserPayment findByUserPaymentId(Long id) {
        return userPaymentRepository.findOne(id);
    }

    @Override
    public void removeByUserPaymentId(Long id) {
        userPaymentRepository.delete(id);
    }
}
