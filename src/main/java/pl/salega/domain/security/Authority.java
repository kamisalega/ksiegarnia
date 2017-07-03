package pl.salega.domain.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by kamilsalega on 22.06.2017.
 */
public class Authority implements GrantedAuthority {
    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
