package com.eproesp.loginSecurity.dao;

import java.util.List;

import com.eproesp.loginSecurity.entity.Instituicao;



public interface InstituicaoDao {
	
	void save(Instituicao instituicao);
	
	void update(Instituicao instituicao);
	
	void delete(Long id);
	
	Instituicao findById(Long id);
	
	List<Instituicao> findAll();
	
}
