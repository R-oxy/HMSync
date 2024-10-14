package com.HMSync.security.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.HMSync.security.user.entity.Permission.ADMIN_CREATE;
import static com.HMSync.security.user.entity.Permission.ADMIN_DELETE;
import static com.HMSync.security.user.entity.Permission.ADMIN_READ;
import static com.HMSync.security.user.entity.Permission.ADMIN_UPDATE;

@RequiredArgsConstructor
public enum Role {

    USER(Set.of()),
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    ADMIN_CREATE
            )
    );

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
