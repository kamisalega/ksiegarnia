package pl.salega.domain.security;

import pl.salega.domain.User;

import javax.persistence.*;

/**
 * Created by kamilsalega on 22.06.2017.
 */

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;


    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }


    public Long getUserRoleId() {
        return userRoleId;
    }


    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public Role getRole() {
        return role;
    }


    public void setRole(Role role) {
        this.role = role;
    }


}