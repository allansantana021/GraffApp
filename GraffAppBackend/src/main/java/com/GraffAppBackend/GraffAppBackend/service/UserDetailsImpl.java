package com.GraffAppBackend.GraffAppBackend.service;


import com.GraffAppBackend.GraffAppBackend.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
    private Usuario usuario;

    public UserDetailsImpl(Usuario usuario){
        this.usuario = usuario;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var authorities = usuario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        System.out.println("PERMISSÕES PARA O USUÁRIO " + usuario.getEmail() + ": " + authorities);

        return authorities;
    }

    @Override
    public String getPassword() {
        return usuario.getSenha();
    }
    @Override
    public String getUsername() {
        return usuario.getEmail();
    }
}
