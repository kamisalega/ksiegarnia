package pl.paneladministracyjny.domain;

import javax.persistence.*;

/**
 * Created by kamilsalega on 14.07.2017.
 */
@Entity
public class UserBilling {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userBillingName;
    private String userBillingStreet1;
    private String UserBillingStreet2;
    private String UserBillingCity;
    private String UserBillingVoivodeships;
    private String UserBillingCountry;
    private String UserBillingPostcode;

    @OneToOne(cascade = CascadeType.ALL)
    private UserPayment userPayment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserBillingName() {
        return userBillingName;
    }

    public void setUserBillingName(String userBillingName) {
        this.userBillingName = userBillingName;
    }

    public String getUserBillingStreet1() {
        return userBillingStreet1;
    }

    public void setUserBillingStreet1(String userBillingStreet1) {
        this.userBillingStreet1 = userBillingStreet1;
    }

    public String getUserBillingStreet2() {
        return UserBillingStreet2;
    }

    public void setUserBillingStreet2(String userBillingStreet2) {
        UserBillingStreet2 = userBillingStreet2;
    }

    public String getUserBillingCity() {
        return UserBillingCity;
    }

    public void setUserBillingCity(String userBillingCity) {
        UserBillingCity = userBillingCity;
    }

    public String getUserBillingVoivodeships() {
        return UserBillingVoivodeships;
    }

    public void setUserBillingVoivodeships(String userBillingVoivodeships) {
        UserBillingVoivodeships = userBillingVoivodeships;
    }

    public String getUserBillingCountry() {
        return UserBillingCountry;
    }

    public void setUserBillingCountry(String userBillingCountry) {
        UserBillingCountry = userBillingCountry;
    }

    public String getUserBillingPostcode() {
        return UserBillingPostcode;
    }

    public void setUserBillingPostcode(String userBillingPostcode) {
        UserBillingPostcode = userBillingPostcode;
    }

    public UserPayment getUserPayment() {
        return userPayment;
    }

    public void setUserPayment(UserPayment userPayment) {
        this.userPayment = userPayment;
    }
}
