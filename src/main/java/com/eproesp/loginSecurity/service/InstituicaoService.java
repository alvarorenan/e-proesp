package com.eproesp.loginSecurity.service;

import java.util.List;

import com.eproesp.loginSecurity.entity.Instituicao;



public interface InstituicaoService {

    void salvar(Instituicao instituicao);

    void editar(Instituicao instituicao);

    void excluir(Long id);

    Instituicao buscarPorId(Long id);
    
    List<Instituicao> buscarTodos();

}
