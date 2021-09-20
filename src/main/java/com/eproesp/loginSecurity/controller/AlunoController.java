package com.eproesp.loginSecurity.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eproesp.loginSecurity.entity.Aluno;
import com.eproesp.loginSecurity.entity.Avaliacoes;
import com.eproesp.loginSecurity.entity.Instituicao;
import com.eproesp.loginSecurity.service.AlunoService;
import com.eproesp.loginSecurity.service.InstituicaoService;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
	
	private static Long idInst;
	@Autowired
	private AlunoService service;

	@Autowired
	private InstituicaoService instService;

//	@GetMapping("/cadastrar")
//	public String cadastrar(Instituicao instituicao) {
//		return "/instituicao/cadastro";
//	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {

		model.addAttribute("alunos", service.buscarTodos());

		return "/instituicao/listaAluno";
	}

	@GetMapping("/popularCombo")
	public String popularCombo(@ModelAttribute("Instituicao") Instituicao instituicao, ModelMap model) {
		model.addAttribute("instituicao", instituicao);
		model.addAttribute("instituicoes", instService.buscarTodos());
		return "/uploadview";
	}

//	@PostMapping("/salvar")
//	public String salvar(Instituicao instituicao, RedirectAttributes attr) {
//		service.salvar(instituicao);
//		attr.addFlashAttribute("success", "Instituicao inserida com sucesso.");
//		return "redirect:/instituicoes/cadastrar";
//	}

//	@GetMapping("/editar/{id}")
//	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
//		model.addAttribute("aluno", service.buscarPorId(id));
//		return "/instituicao/cadastro";
//	}

//	@PostMapping("/editar")
//	public String editar(Aluno aluno, RedirectAttributes attr) {
//		service.editar(instituicao);
//		attr.addFlashAttribute("success", "Instituicao editada com sucesso.");
//		return "redirect:/instituicoes/cadastrar";
//	}

	@PostMapping("**/pesquisaaluno")
	public ModelAndView pesquisar(@RequestParam("nomepesquisa") String nomepesquisa,
			@RequestParam("sexopesquisa") String sexopesquisa, @RequestParam("idadepesquisa") int idadepesquisa,
			@RequestParam("imc") String imc) {
		Avaliacoes calc = new Avaliacoes();
		List<Aluno> lista = new ArrayList();
		List<Double> imcMediana = new ArrayList();
		List<Double> sAsMediana = new ArrayList();
		List<Double> abdmsMediana = new ArrayList();
		List<Double> corr6Mediana = new ArrayList();
		List<Double> corr9Mediana = new ArrayList();
		List<Double> saltDistMediana = new ArrayList();
		List<Double> arremessoBallMediana = new ArrayList();
		List<Double> testQuadradoMediana = new ArrayList();
		List<Double> corrida20mMediana = new ArrayList();
		double imcMedianaResult=0, sAsMedianaResult=0, abdmsMedianaResult = 0, corr6MedianaResult = 0,
				corr9MedianaResult = 0, saltDistMedianaResult = 0, arremessoBallMedianaResult = 0,
				testQuadradoMedianaResult = 0, corrida20mMedianaResult = 0;
		lista = service.filtrar(nomepesquisa,sexopesquisa,idadepesquisa,imc);
		double imcs = 0, mediaImc;
		double sAs = 0, mediaSA = 0;
		double abdms = 0, mediaAbdms = 0;
		double corr6 = 0, mediaCorr6 = 0;
		double corr9 = 0, mediaCorr9 = 0;
		double saltDist = 0, mediaSaltDist = 0;
		double arremessoBall = 0, mediaArremessoBall = 0;
		double testQuadrado = 0, mediaTestQuadrado=0;
		double corrida20m = 0, mediaCorrida20 = 0;
		for (Aluno a : lista) {
			imcMediana.add(a.getImc());
			sAsMediana.add(a.getSentarAlcancar());
			abdmsMediana.add((double) a.getQtdAbdominal());
			corr6Mediana.add(a.getCorrida6min());
			corr9Mediana.add(a.getCorrida9min());
			saltDistMediana.add(a.getSaltoDistancia());
			arremessoBallMediana.add(a.getArremessoBall());
			testQuadradoMediana.add(a.getTesteQuadrado());
			corrida20mMediana.add((double) a.getCorrida20metros());
			
			imcs += a.getImc();
			sAs += a.getSentarAlcancar();
			abdms += a.getQtdAbdominal();
			corr6 +=a.getCorrida6min();
			corr9 += a.getCorrida9min();
			saltDist += a.getSaltoDistancia();
			arremessoBall += a.getArremessoBall();
			testQuadrado += a.getTesteQuadrado();
			corrida20m += a.getCorrida20metros();
		}
		mediaSA = sAs / lista.size();
		mediaImc = imcs / lista.size();
		mediaSA = sAs / lista.size();
		mediaImc = imcs / lista.size();
		mediaAbdms = abdms / lista.size();
		mediaCorr6 = corr6 / lista.size();
		mediaCorr9 = corr9 / lista.size();
		mediaSaltDist = saltDist / lista.size();
		mediaArremessoBall = arremessoBall / lista.size();
		mediaTestQuadrado = testQuadrado / lista.size();
		mediaCorrida20 = corrida20m / lista.size();

		if(imcMediana.size()!=0) {
		imcMedianaResult= calc.calcularMediana(imcMediana);
		}
		if(sAsMediana.size()!=0) {
			sAsMedianaResult = calc.calcularMediana(sAsMediana);
		}
		if(abdmsMediana.size()!=0) {
			abdmsMedianaResult = calc.calcularMediana(abdmsMediana);
		}
		if(corr6Mediana.size()!=0) {
			corr6MedianaResult = calc.calcularMediana(corr6Mediana);
		}
		if(corr9Mediana.size()!=0) {
			corr9MedianaResult = calc.calcularMediana(corr9Mediana);
		}
		if(saltDistMediana.size()!=0) {
			saltDistMedianaResult = calc.calcularMediana(saltDistMediana);
		}
		if(arremessoBallMediana.size()!=0) {
			arremessoBallMedianaResult = calc.calcularMediana(arremessoBallMediana);
		}
		if(testQuadradoMediana.size()!=0) {
			testQuadradoMedianaResult = calc.calcularMediana(testQuadradoMediana);
		}
		if(corrida20mMediana.size()!=0) {
			corrida20mMedianaResult = calc.calcularMediana(corrida20mMediana);
		}
		
		ModelAndView modelAndView = new ModelAndView("instituicao/listaAluno");
		modelAndView.addObject("alunos", service.filtrar(nomepesquisa, sexopesquisa, idadepesquisa, imc));
		modelAndView.addObject("mediaImc", mediaImc);
		modelAndView.addObject("mediaSA", mediaSA);
		modelAndView.addObject("mediaAbdms", mediaAbdms);
		modelAndView.addObject("mediaCorr6", mediaCorr6);
		modelAndView.addObject("mediaCorr9", mediaCorr9);
		modelAndView.addObject("mediaSaltDist", mediaSaltDist);
		modelAndView.addObject("mediaArremessoBall", mediaArremessoBall);
		modelAndView.addObject("mediaTestQuadrado", mediaTestQuadrado);
		modelAndView.addObject("mediaCorrida20", mediaCorrida20);
		
		modelAndView.addObject("imcMedianaResult", imcMedianaResult);
		modelAndView.addObject("sAsMedianaResult", sAsMedianaResult);
		modelAndView.addObject("abdmsMedianaResult", abdmsMedianaResult);
		modelAndView.addObject("corr6MedianaResult", corr6MedianaResult);
		modelAndView.addObject("corr9MedianaResult", corr9MedianaResult);
		modelAndView.addObject("saltDistMedianaResult", saltDistMedianaResult);
		modelAndView.addObject("arremessoBallMedianaResult", arremessoBallMedianaResult);
		modelAndView.addObject("testQuadradoMedianaResult", testQuadradoMedianaResult);
		modelAndView.addObject("corrida20mMedianaResult", corrida20mMedianaResult);
		
		double desvioImc = calc.calcularDesvioPadrao(imcMediana, mediaImc);
		double desvioSA = calc.calcularDesvioPadrao(sAsMediana, mediaSA);
		double desvioAbdms = calc.calcularDesvioPadrao(abdmsMediana, mediaAbdms);
		double desvioCorr6 = calc.calcularDesvioPadrao(corr6Mediana, mediaCorr6);
		double desvioCorr9 = calc.calcularDesvioPadrao(corr9Mediana, mediaCorr9);
		double desvioSaltDist = calc.calcularDesvioPadrao(saltDistMediana, mediaSaltDist);
		double desvioArremessoBall = calc.calcularDesvioPadrao(arremessoBallMediana, mediaArremessoBall);
		double desvioTestQuadrado = calc.calcularDesvioPadrao(testQuadradoMediana, mediaTestQuadrado);
		double desvioCorrida20m = calc.calcularDesvioPadrao(corrida20mMediana, mediaCorrida20);

		modelAndView.addObject("desvioImc", desvioImc);
		modelAndView.addObject("desvioSA", desvioSA);
		modelAndView.addObject("desvioAbdms", desvioAbdms);
		modelAndView.addObject("desvioCorr6", desvioCorr6);
		modelAndView.addObject("desvioCorr9", desvioCorr9);
		modelAndView.addObject("desvioSaltDist", desvioSaltDist);
		modelAndView.addObject("desvioArremessoBall", desvioArremessoBall);
		modelAndView.addObject("desvioTestQuadrado", desvioTestQuadrado);
		modelAndView.addObject("desvioCorrida20m", desvioCorrida20m);
		
		return modelAndView;
	}

	@GetMapping("/listar/{id}")
	public String listarId(@PathVariable("id") Long id, ModelMap model) {

		model.addAttribute("aluno", service.buscarPorId(id));

		return "instituicao/viewAluno";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		Long idAux;
		idAux = service.buscarPorId(id).getInstituicao().getId();
		service.excluir(id);
		model.addAttribute("success", "Aluno excluído com sucesso.");

		return listarAlunos(idAux, model);
	}

	@GetMapping("/listarAlunos/{id}")
	public String listarAlunos(@PathVariable("id") Long id, ModelMap model) {
		Avaliacoes calc = new Avaliacoes();
		List<Aluno> lista = new ArrayList();
		List<Double> imcMediana = new ArrayList();
		List<Double> sAsMediana = new ArrayList();
		List<Double> abdmsMediana = new ArrayList();
		List<Double> corr6Mediana = new ArrayList();
		List<Double> corr9Mediana = new ArrayList();
		List<Double> saltDistMediana = new ArrayList();
		List<Double> arremessoBallMediana = new ArrayList();
		List<Double> testQuadradoMediana = new ArrayList();
		List<Double> corrida20mMediana = new ArrayList();
		double imcMedianaResult=0, sAsMedianaResult=0, abdmsMedianaResult = 0, corr6MedianaResult = 0,
				corr9MedianaResult = 0, saltDistMedianaResult = 0, arremessoBallMedianaResult = 0,
				testQuadradoMedianaResult = 0, corrida20mMedianaResult = 0;
		
		idInst=id;
		lista = service.buscarInst(id);
		double imcs = 0, mediaImc;
		double sAs = 0, mediaSA = 0;
		double abdms = 0, mediaAbdms = 0;
		double corr6 = 0, mediaCorr6 = 0;
		double corr9 = 0, mediaCorr9 = 0;
		double saltDist = 0, mediaSaltDist = 0;
		double arremessoBall = 0, mediaArremessoBall = 0;
		double testQuadrado = 0, mediaTestQuadrado=0;
		double corrida20m = 0, mediaCorrida20 = 0;
		for (Aluno a : lista) {
			imcMediana.add(a.getImc());
			sAsMediana.add(a.getSentarAlcancar());
			abdmsMediana.add((double) a.getQtdAbdominal());
			corr6Mediana.add(a.getCorrida6min());
			corr9Mediana.add(a.getCorrida9min());
			saltDistMediana.add(a.getSaltoDistancia());
			arremessoBallMediana.add(a.getArremessoBall());
			testQuadradoMediana.add(a.getTesteQuadrado());
			corrida20mMediana.add((double) a.getCorrida20metros());
			
			imcs += a.getImc();
			sAs += a.getSentarAlcancar();
			abdms += a.getQtdAbdominal();
			corr6 +=a.getCorrida6min();
			corr9 += a.getCorrida9min();
			saltDist += a.getSaltoDistancia();
			arremessoBall += a.getArremessoBall();
			testQuadrado += a.getTesteQuadrado();
			corrida20m += a.getCorrida20metros();
		}
		mediaSA = sAs / lista.size();
		mediaImc = imcs / lista.size();
		mediaAbdms = abdms / lista.size();
		mediaCorr6 = corr6 / lista.size();
		mediaCorr9 = corr9 / lista.size();
		mediaSaltDist = saltDist / lista.size();
		mediaArremessoBall = arremessoBall / lista.size();
		mediaTestQuadrado = testQuadrado / lista.size();
		mediaCorrida20 = corrida20m / lista.size();
		
		if(imcMediana.size()!=0) {
		imcMedianaResult= calc.calcularMediana(imcMediana);
		}
		if(sAsMediana.size()!=0) {
			sAsMedianaResult = calc.calcularMediana(sAsMediana);
		}
		if(abdmsMediana.size()!=0) {
			abdmsMedianaResult = calc.calcularMediana(abdmsMediana);
		}
		if(corr6Mediana.size()!=0) {
			corr6MedianaResult = calc.calcularMediana(corr6Mediana);
		}
		if(corr9Mediana.size()!=0) {
			corr9MedianaResult = calc.calcularMediana(corr9Mediana);
		}
		if(saltDistMediana.size()!=0) {
			saltDistMedianaResult = calc.calcularMediana(saltDistMediana);
		}
		if(arremessoBallMediana.size()!=0) {
			arremessoBallMedianaResult = calc.calcularMediana(arremessoBallMediana);
		}
		if(testQuadradoMediana.size()!=0) {
			testQuadradoMedianaResult = calc.calcularMediana(testQuadradoMediana);
		}
		if(corrida20mMediana.size()!=0) {
			corrida20mMedianaResult = calc.calcularMediana(corrida20mMediana);
		}
		model.addAttribute("mediaImc", mediaImc);
		model.addAttribute("mediaSA", mediaSA);
		model.addAttribute("mediaAbdms", mediaAbdms);
		model.addAttribute("mediaCorr6", mediaCorr6);
		model.addAttribute("mediaCorr9", mediaCorr9);
		model.addAttribute("mediaSaltDist", mediaSaltDist);
		model.addAttribute("mediaArremessoBall", mediaArremessoBall);
		model.addAttribute("mediaTestQuadrado", mediaTestQuadrado);
		model.addAttribute("mediaCorrida20", mediaCorrida20);

		model.addAttribute("imcMedianaResult", imcMedianaResult);
		model.addAttribute("sAsMedianaResult", sAsMedianaResult);
		model.addAttribute("abdmsMedianaResult", abdmsMedianaResult);
		model.addAttribute("corr6MedianaResult", corr6MedianaResult);
		model.addAttribute("corr9MedianaResult", corr9MedianaResult);
		model.addAttribute("saltDistMedianaResult", saltDistMedianaResult);
		model.addAttribute("arremessoBallMedianaResult", arremessoBallMedianaResult);
		model.addAttribute("testQuadradoMedianaResult", testQuadradoMedianaResult);
		model.addAttribute("corrida20mMedianaResult", corrida20mMedianaResult);

		double desvioImc = calc.calcularDesvioPadrao(imcMediana, mediaImc);
		double desvioSA = calc.calcularDesvioPadrao(sAsMediana, mediaSA);
		double desvioAbdms = calc.calcularDesvioPadrao(abdmsMediana, mediaAbdms);
		double desvioCorr6 = calc.calcularDesvioPadrao(corr6Mediana, mediaCorr6);
		double desvioCorr9 = calc.calcularDesvioPadrao(corr9Mediana, mediaCorr9);
		double desvioSaltDist = calc.calcularDesvioPadrao(saltDistMediana, mediaSaltDist);
		double desvioArremessoBall = calc.calcularDesvioPadrao(arremessoBallMediana, mediaArremessoBall);
		double desvioTestQuadrado = calc.calcularDesvioPadrao(testQuadradoMediana, mediaTestQuadrado);
		double desvioCorrida20m = calc.calcularDesvioPadrao(corrida20mMediana, mediaCorrida20);

		model.addAttribute("desvioImc", desvioImc);
		model.addAttribute("desvioSA", desvioSA);
		model.addAttribute("desvioAbdms", desvioAbdms);
		model.addAttribute("desvioCorr6", desvioCorr6);
		model.addAttribute("desvioCorr9", desvioCorr9);
		model.addAttribute("desvioSaltDist", desvioSaltDist);
		model.addAttribute("desvioArremessoBall", desvioArremessoBall);
		model.addAttribute("desvioTestQuadrado", desvioTestQuadrado);
		model.addAttribute("desvioCorrida20m", desvioCorrida20m);
		
		
		
		model.addAttribute("alunos", service.buscarInst(id));
		return "/instituicao/listaAluno";
	}

}
