package com.eproesp.loginSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eproesp.loginSecurity.dao.InstituicaoDao;
import com.eproesp.loginSecurity.entity.Instituicao;

@Service
public class InstituicaoServiceImpl implements InstituicaoService {
	
	@Autowired
	private InstituicaoDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Instituicao instituicao) {
		dao.save(instituicao);		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Instituicao instituicao) {
		dao.update(instituicao);		
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public Instituicao buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Instituicao> buscarTodos() {
		
		return dao.findAll();
	}

	

//	@Override
//	public boolean depertamentoTemCargos(Long id) {
//		if (buscarPorId(id).getCargos().isEmpty()) {
//			return false;
//		}
//		return true;
//	}

}
