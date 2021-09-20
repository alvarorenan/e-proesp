package com.eproesp.loginSecurity.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eproesp.loginSecurity.entity.Authority;
import com.eproesp.loginSecurity.entity.Role;
import com.eproesp.loginSecurity.entity.User;
import com.eproesp.loginSecurity.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
	private PasswordEncoder passwordEncoder;
  
    
    @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	UserDetails user = userRepository.findByUsername(username);
		
		org.springframework.security.core.userdetails.User userFinal = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getPermissoes(user));
		System.out.println(userFinal.getAuthorities());
		return userFinal;
    }
    
    private Collection<? extends GrantedAuthority> getPermissoes(UserDetails usuario) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
			
		Set<Role> permissoes =  ((User) usuario).getRole();
		for( Role r : permissoes ) {
			 authorities.add( new SimpleGrantedAuthority(r.getNome().toUpperCase() ) );
		}
		
		
		return authorities;
	}
    public void salvar(com.eproesp.loginSecurity.entity.User u) {
    	//Condificando a senha

    	System.out.println(u.getNome());
    	u.setPassword( passwordEncoder.encode(u.getPassword() ));
		u.setDataCriacao(new Date());
		u.setEnabled(true);
		Role r = new Role(new Long(1));
		u.getRole().add(r);
		
		userRepository.save(u);
    }
    public Object findAll() {
		return userRepository.findAll();
	}
}