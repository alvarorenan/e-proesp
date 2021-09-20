package com.eproesp.loginSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.eproesp.loginSecurity.entity.Role;
import com.eproesp.loginSecurity.repository.RoleRepository;



@Service
public class RoleService {
	
		@Autowired
		private RoleRepository repository;
		
		public List<Role> buscarTodos(){
			return repository.findAll();
		}
}
