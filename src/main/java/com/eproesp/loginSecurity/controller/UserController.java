package com.eproesp.loginSecurity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eproesp.loginSecurity.entity.Instituicao;
import com.eproesp.loginSecurity.entity.User;
import com.eproesp.loginSecurity.service.RoleService;
import com.eproesp.loginSecurity.service.UserDetailsServiceImpl;

@Controller
@RequestMapping("/usuario")
public class UserController {

	@Autowired
	UserDetailsServiceImpl userService;
	@Autowired
	private RoleService roleService;
//	@GetMapping("/cadastrar")
//	public String cadastrar(User user) {
//		return "/cadastro";
//	}
	
//	@PostMapping("/salvar")
//	public String salvar(User user, RedirectAttributes attr) {
////		user.setId(user.getId()+1);
//		userService.salvar(user);
//		attr.addFlashAttribute("success", "Usuário cadastrado com sucesso.");
//		return "redirect:/index";
//	}

	@RequestMapping("/cadastrar")
	public ModelAndView add(User user) {
		System.out.println("cadastro");

		System.out.println("cadastro");
		System.out.println("cadastro");
		System.out.println("cadastro");
		System.out.println("cadastro");
		System.out.println("cadastro");
		System.out.println("cadastro");
		System.out.println("cadastro");
		System.out.println("cadastro");
		ModelAndView mv = new ModelAndView("/cadastro");
		mv.addObject("user", user);
		mv.addObject("roles", roleService.buscarTodos());
		return mv;
	}
	@PostMapping("/save")
	public ModelAndView save(@Valid User user, BindingResult result) {

    	System.out.println(user.getNome());
    	System.out.println(user.getNome());
    	System.out.println(user.getId());
    	System.out.println(user.getPassword());
    	System.out.println(user.getTelefone());
    	System.out.println(user.getEmail());
    	for (Object object : result.getAllErrors()) {
    	    if(object instanceof FieldError) {
    	        FieldError fieldError = (FieldError) object;

    	        System.out.println(fieldError.getCode());
    	    }

    	    if(object instanceof ObjectError) {
    	        ObjectError objectError = (ObjectError) object;

    	        System.out.println(objectError.getCode());
    	    }
    	}
    	System.out.println(user.getNome());
    	System.out.println(user.getNome());
		if (result.hasErrors()) {
			return add(user);
		}
		System.out.println("salvar");
		System.out.println("salvar");
		System.out.println("salvar");
		System.out.println("salvar");
		System.out.println("salvar");
		System.out.println("salvar");
		System.out.println("salvar");
		System.out.println("salvar");
		userService.salvar(user);
		ModelAndView rec = new ModelAndView("/index");
		return rec;
	}

}
