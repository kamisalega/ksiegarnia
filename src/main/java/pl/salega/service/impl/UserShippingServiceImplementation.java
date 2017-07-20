package pl.salega.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.salega.domain.UserShipping;
import pl.salega.repository.UserShippingRepository;
import pl.salega.service.UserShippingService;

/**
 * Created by kamilsalega on 20.07.2017.
 */

@Service
public class UserShippingServiceImplementation implements UserShippingService {

    @Autowired
    private UserShippingRepository userShippingRepository;

    @Override
    public UserShipping findByUserShippingId(Long id) {
        return userShippingRepository.findOne(id);
    }

    @Override
    public void removeByUserShippingId(Long id) {
        userShippingRepository.delete(id);
    }
}
