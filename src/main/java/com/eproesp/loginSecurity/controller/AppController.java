package com.eproesp.loginSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eproesp.loginSecurity.entity.Instituicao;

@Controller

public class AppController {

	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}


	
	@GetMapping("/menu")
	public String menu() {
		return "home";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin(Instituicao instituicao) {
		return "/instituicao/cadastro";
	}
}
