package com.eproesp.loginSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eproesp.loginSecurity.dao.AlunoDao;
import com.eproesp.loginSecurity.entity.Aluno;

@Service
public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
	private AlunoDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Aluno aluno) {
		dao.save(aluno);		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Aluno aluno) {
		dao.update(aluno);		
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public Aluno buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Aluno> buscarTodos() {
		
		return dao.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Aluno> filtrar(String nome, String sexo, int idade, String imc) {
		
		return dao.filtrar(nome, sexo, idade, imc);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Aluno> buscarInst(Long id) {
		
		return dao.buscarInst(id);
	}
}
