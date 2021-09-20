package com.eproesp.loginSecurity.dao;

import java.util.List;

import com.eproesp.loginSecurity.entity.Aluno;

public interface AlunoDao {
	void save(Aluno aluno);
	
	void update(Aluno aluno);
	
	void delete(Long id);
	
	Aluno findById(Long id);

	List<Aluno> findAll();
	
	List<Aluno> filtrar(String nome, String sexo, int idade, String imc);

	List<Aluno> buscarInst(Long id);
	
}
