package com.amaterasu.auth_service.entities;

import com.amaterasu.auth_service.enums.Roles;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Table(name = "users")
@Entity
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled", columnDefinition = "boolean default true")
    private boolean enabled;

    @Column(name = "account_non_expired", columnDefinition = "boolean default false")
    private boolean accountNonExpired;

    @Column(name = "account_non_locked", columnDefinition = "boolean default false")
    private boolean accountNonLocked;

    @Column(name = "credentials_non_expired", columnDefinition = "boolean default false")
    private boolean credentialsNonExpired;

    @Column(name = "roles")
    private String roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String[] split = roles.split(",");
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : split) {
            Arrays.stream(Roles.valueOf(role).getAuthorities().split(","))
                    .forEach(authority -> authorities.add((GrantedAuthority) () -> authority));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isCredentialsNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public List<String> getRoles() {
        return Arrays.stream(roles.split(",")).collect(Collectors.toList());
    }
}
