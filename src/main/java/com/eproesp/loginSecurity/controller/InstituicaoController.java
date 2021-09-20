package com.eproesp.loginSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eproesp.loginSecurity.entity.Instituicao;
import com.eproesp.loginSecurity.service.AlunoService;
import com.eproesp.loginSecurity.service.InstituicaoService;

@Controller
@RequestMapping("/instituicoes")
public class InstituicaoController {

	@Autowired
	private InstituicaoService service;
	


	@GetMapping("/cadastrar")
	public String cadastrar(Instituicao instituicao) {
		return "/instituicao/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("instituicoes", service.buscarTodos());
		return "/instituicao/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Instituicao instituicao, RedirectAttributes attr) {
		service.salvar(instituicao);
		attr.addFlashAttribute("success", "Instituicao inserida com sucesso.");
		return "redirect:/instituicoes/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("instituicao", service.buscarPorId(id));
		return "/instituicao/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Instituicao instituicao, RedirectAttributes attr) {
		service.editar(instituicao);
		attr.addFlashAttribute("success", "Instituicao editada com sucesso.");
		return "redirect:/instituicoes/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {

		service.excluir(id);
		model.addAttribute("success", "Instituicao excluída com sucesso.");

		return listar(model);
	}
	
	
}
