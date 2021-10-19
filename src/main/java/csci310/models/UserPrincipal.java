package csci310.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {
    private User user;
    private String username;

    @JsonIgnore
    private String password;

    private Collection<GrantedAuthority> authorities;

    public UserPrincipal(String username, String password){
        this.username = username;
        this.password = password;
        authorities = new ArrayList<>();
        SimpleGrantedAuthority role = new SimpleGrantedAuthority("USER");
        authorities.add(role);
    }

    public UserPrincipal(User user) {
        this(user.getUsername(), user.getPassword());
        this.user = user;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
