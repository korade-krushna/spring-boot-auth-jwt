package com.amaterasu.auth_service.enums;

public enum Roles {
    USER("READ"),
    ADMIN("READ,WRITE");

    private final String authorities;
    Roles(String authorities) {
        this.authorities = authorities;
    }

    public String getAuthorities() {
        return authorities;
    }

}
