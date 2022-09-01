package com.endava.tmd.bookclubproject.security;

import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;
import com.endava.tmd.bookclubproject.security.UserPermission.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static com.endava.tmd.bookclubproject.security.UserPermission.*;

public enum UserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(USER_ADDBOOK, USER_BORROWBOOK));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}