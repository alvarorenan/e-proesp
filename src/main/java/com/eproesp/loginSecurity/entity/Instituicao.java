package com.eproesp.loginSecurity.entity;



import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "INSTITUICOES")
public class Instituicao extends AbstractEntity<Long>{
	
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;

	@Column(name = "endereco", nullable = false, unique = true, length = 60)
	private String endereco;
	
	@Column(name = "telProf", nullable = true, unique = true, length = 60)
	private String telProf;
	
	@Column(name = "telInst", nullable = true, unique = true, length = 60)
	private String telInst;

	@Column(name = "emailProf", nullable = true, unique = true, length = 60)
	private String emailProf;

	@Column(name = "nomeProf", nullable = true, unique = true, length = 60)
	private String nomeProf;

	
	public String getEndereco() {
		return endereco;
	}

	public String getNomeProf() {
		return nomeProf;
	}

	public void setNomeProf(String nomeProf) {
		this.nomeProf = nomeProf;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelProf() {
		return telProf;
	}

	public void setTelProf(String telProf) {
		this.telProf = telProf;
	}

	public String getTelInst() {
		return telInst;
	}

	public void setTelInst(String telInst) {
		this.telInst = telInst;
	}

	public String getEmailProf() {
		return emailProf;
	}

	public void setEmailProf(String emailProf) {
		this.emailProf = emailProf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

}
