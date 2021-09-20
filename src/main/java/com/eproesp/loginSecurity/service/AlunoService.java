package com.eproesp.loginSecurity.service;

import java.util.List;

import com.eproesp.loginSecurity.entity.Aluno;

public interface AlunoService {
	void salvar(Aluno aluno);

	void editar(Aluno aluno);

	void excluir(Long id);

	Aluno buscarPorId(Long id);

	List<Aluno> buscarTodos();
	
	List<Aluno> filtrar(String nome, String sexo, int idade, String imc);
	
	List<Aluno> buscarInst(Long id);
}
