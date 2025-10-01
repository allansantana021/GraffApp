package com.GraffAppBackend.GraffAppBackend.service;

import com.GraffAppBackend.GraffAppBackend.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections; // Importação adicionada para retornar lista vazia de authorities

public class UserDetailsImpl implements UserDetails {

    private final Usuario usuario; // Classe de usuário que criamos anteriormente

    public UserDetailsImpl(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*
         * NOTA: Sua Entity 'Usuario' não tem um método 'getRoles()'.
         * Por padrão, retornamos uma coleção vazia para compilação.
         * Você deve substituir esta linha pela lógica de roles quando as implementar.
         */
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        // CORRIGIDO: Retorna a senha usando o método correto 'getSenha()' da instância 'usuario'
        return usuario.getSenha();
    }

    @Override
    public String getUsername() {
        // CORRIGIDO: Retorna o email (o nome de usuário) usando o método 'getEmail()' da instância 'usuario'
        return usuario.getEmail();
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

}