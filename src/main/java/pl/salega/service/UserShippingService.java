package pl.salega.service;

import pl.salega.domain.UserShipping;

/**
 * Created by kamilsalega on 20.07.2017.
 */
public interface UserShippingService {

    UserShipping findByUserShippingId(Long id);

    void removeByUserShippingId(Long id);
}
