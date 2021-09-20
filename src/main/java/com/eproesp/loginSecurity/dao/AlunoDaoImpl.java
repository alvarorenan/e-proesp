package com.eproesp.loginSecurity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eproesp.loginSecurity.entity.Aluno;

@Repository
public class AlunoDaoImpl extends AbstractDao<Aluno, Long> implements AlunoDao {

	private static long idInst = 0;

	public List filtrar(String nome, String sexo, int idade, String imc) {

		String consulta = "select a from Aluno a where 1=1";
		if (!imc.isEmpty()) {
			String temp = null;
			if (imc.equals("risco")) {
				temp = " and (a.sexo like '%M%' and a.idade = 6 and a.massaCorporal/(a.estatura * a.estatura) > 17.7"
						+ " or a.sexo like '%M%' and a.idade = 7 and a.massaCorporal/(a.estatura * a.estatura) > 17.8"
						+ " or a.sexo like '%M%' and a.idade = 8 and a.massaCorporal/(a.estatura * a.estatura) > 19.2"
						+ " or a.sexo like '%M%' and a.idade = 9 and a.massaCorporal/(a.estatura * a.estatura) > 19.3"
						+ " or a.sexo like '%M%' and a.idade = 10 and a.massaCorporal/(a.estatura * a.estatura) > 20.7"
						+ " or a.sexo like '%M%' and a.idade = 11 and a.massaCorporal/(a.estatura * a.estatura) > 22.1"
						+ " or a.sexo like '%M%' and a.idade = 12 and a.massaCorporal/(a.estatura * a.estatura) > 22.2"
						+ " or a.sexo like '%M%' and a.idade = 13 and a.massaCorporal/(a.estatura * a.estatura) > 22"
						+ " or a.sexo like '%M%' and a.idade = 14 and a.massaCorporal/(a.estatura * a.estatura) > 22.2"
						+ " or a.sexo like '%M%' and a.idade = 15 and a.massaCorporal/(a.estatura * a.estatura) > 23"
						+ " or a.sexo like '%M%' and a.idade = 16 and a.massaCorporal/(a.estatura * a.estatura) > 24"
						+ " or a.sexo like '%M%' and a.idade = 17 and a.massaCorporal/(a.estatura * a.estatura) > 25.4"
					//
						//
					//
						//
					//
						//
						+ " or a.sexo like '%F%' and a.idade = 6 and a.massaCorporal/(a.estatura * a.estatura) > 17"
						+ " or a.sexo like '%F%' and a.idade = 7 and a.massaCorporal/(a.estatura * a.estatura) > 17.1"
						+ " or a.sexo like '%F%' and a.idade = 8 and a.massaCorporal/(a.estatura * a.estatura) > 18.2"
						+ " or a.sexo like '%F%' and a.idade = 9 and a.massaCorporal/(a.estatura * a.estatura) > 19.1"
						+ " or a.sexo like '%F%' and a.idade = 10 and a.massaCorporal/(a.estatura * a.estatura) > 20.9"
						+ " or a.sexo like '%F%' and a.idade = 11 and a.massaCorporal/(a.estatura * a.estatura) > 22.3"
						+ " or a.sexo like '%F%' and a.idade = 12 and a.massaCorporal/(a.estatura * a.estatura) > 22.6"
						+ " or a.sexo like '%F%' and a.idade = 13 and a.massaCorporal/(a.estatura * a.estatura) > 22"
						+ " or a.sexo like '%F%' and a.idade = 14 and a.massaCorporal/(a.estatura * a.estatura) > 22"
						+ " or a.sexo like '%F%' and a.idade = 15 and a.massaCorporal/(a.estatura * a.estatura) > 22.4"
						+ " or a.sexo like '%F%' and a.idade = 16 and a.massaCorporal/(a.estatura * a.estatura) > 24"
						+ " or a.sexo like '%F%' and a.idade = 17 and a.massaCorporal/(a.estatura * a.estatura) > 24)"
						;

				consulta = consulta + temp;
			}
			if (imc.equals("saudavel")) {
				temp = " and (a.sexo like '%M%' and a.idade = 6 and a.massaCorporal/(a.estatura * a.estatura) <= 17.7"
						+ " or a.sexo like '%M%' and a.idade = 7 and a.massaCorporal/(a.estatura * a.estatura) <= 17.8"
						+ " or a.sexo like '%M%' and a.idade = 8 and a.massaCorporal/(a.estatura * a.estatura) <= 19.2"
						+ " or a.sexo like '%M%' and a.idade = 9 and a.massaCorporal/(a.estatura * a.estatura) <= 19.3"
						+ " or a.sexo like '%M%' and a.idade = 10 and a.massaCorporal/(a.estatura * a.estatura) <= 20.7"
						+ " or a.sexo like '%M%' and a.idade = 11 and a.massaCorporal/(a.estatura * a.estatura) <= 22.1"
						+ " or a.sexo like '%M%' and a.idade = 12 and a.massaCorporal/(a.estatura * a.estatura) <= 22.2"
						+ " or a.sexo like '%M%' and a.idade = 13 and a.massaCorporal/(a.estatura * a.estatura) <= 22"
						+ " or a.sexo like '%M%' and a.idade = 14 and a.massaCorporal/(a.estatura * a.estatura) <= 22.2"
						+ " or a.sexo like '%M%' and a.idade = 15 and a.massaCorporal/(a.estatura * a.estatura) <= 23"
						+ " or a.sexo like '%M%' and a.idade = 16 and a.massaCorporal/(a.estatura * a.estatura) <= 24"
						+ " or a.sexo like '%M%' and a.idade = 17 and a.massaCorporal/(a.estatura * a.estatura) <= 25.4"
					//
						//
					//
						//
					//
						//
						+ " or a.sexo like '%F%' and a.idade = 6 and a.massaCorporal/(a.estatura * a.estatura) <= 17"
						+ " or a.sexo like '%F%' and a.idade = 7 and a.massaCorporal/(a.estatura * a.estatura) <= 17.1"
						+ " or a.sexo like '%F%' and a.idade = 8 and a.massaCorporal/(a.estatura * a.estatura) <= 18.2"
						+ " or a.sexo like '%F%' and a.idade = 9 and a.massaCorporal/(a.estatura * a.estatura) <= 19.1"
						+ " or a.sexo like '%F%' and a.idade = 10 and a.massaCorporal/(a.estatura * a.estatura) <= 20.9"
						+ " or a.sexo like '%F%' and a.idade = 11 and a.massaCorporal/(a.estatura * a.estatura) <= 22.3"
						+ " or a.sexo like '%F%' and a.idade = 12 and a.massaCorporal/(a.estatura * a.estatura) <= 22.6"
						+ " or a.sexo like '%F%' and a.idade = 13 and a.massaCorporal/(a.estatura * a.estatura) <= 22"
						+ " or a.sexo like '%F%' and a.idade = 14 and a.massaCorporal/(a.estatura * a.estatura) <= 22"
						+ " or a.sexo like '%F%' and a.idade = 15 and a.massaCorporal/(a.estatura * a.estatura) <= 22.4"
						+ " or a.sexo like '%F%' and a.idade = 16 and a.massaCorporal/(a.estatura * a.estatura) <= 24"
						+ " or a.sexo like '%F%' and a.idade = 17 and a.massaCorporal/(a.estatura * a.estatura) <= 24)"
						;

				consulta = consulta + temp;
			}
		}
		if (idInst != 0) {
			System.out.println(idInst);
			String temp = " and a.instituicao.id = " + idInst;
			consulta = consulta + temp;
		}
		if (!nome.isEmpty()) {
			String temp = " and a.nome like '%" + nome + "%'";
			consulta = consulta + temp;
		}
		if (!sexo.isEmpty()) {
			String temp = " and a.sexo like '%" + sexo + "%'";
			consulta = consulta + temp;
		}
		if (idade != 0) {
			String temp = " and a.idade = " + idade;
			consulta = consulta + temp;
		}
		
		System.out.println(consulta);
		System.out.println(consulta);
		System.out.println(consulta);
		System.out.println(consulta);
		System.out.println(consulta);
		System.out.println(consulta);
		System.out.println(consulta);
		
//		if (idade>0) {
//			consulta.concat("and a.idade >= :idade");
//		}
		return getEntityManager().createQuery(consulta).getResultList();
	}

	public List buscarInst(Long id) {
		idInst = id;
		String consulta = "select a from Aluno a where a.instituicao = " + id;
		return getEntityManager().createQuery(consulta).getResultList();
	}
}
