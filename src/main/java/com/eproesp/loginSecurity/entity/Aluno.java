package com.eproesp.loginSecurity.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Table(name = "ALUNOS")
public class Aluno extends AbstractEntity<Long> {
	
	@ManyToOne
	@JoinColumn(name="idInstituicao")
	private Instituicao instituicao;
	
	@Column(name = "nomeAluno", nullable = true, unique = false, length = 60)
	private String nome;

	@Column(name = "esporteAluno", nullable = true, unique = false, length = 60)
	private String esporte;

	@Column(name = "idadeAluno", nullable = true)
	private int idade;

	@Column(name = "dataN", nullable = true, unique = false)
	private Date dataN;

	@Column(name = "sexoAluno", nullable = true, unique = false)
	private String sexo;

	@Column(name = "freqSemanal", nullable = true, unique = false)
	private String freqSemanal;

	@Column(name = "duracaoMediaSecao", nullable = true, unique = false)
	private String duracaoMediaSecao;

	@Column(name = "tempoPratica", nullable = true, unique = false)
	private String tempoPratica;

	@Column(name = "deficiencia", nullable = true, unique = false)
	private String deficiencia;

	@Column(name = "dataAv", nullable = true, unique = false)
	private Date dataAv;

	@Column(name = "horaAv", nullable = true, unique = false)
	private String horaAv;

	@Column(name = "temperaturaAv", nullable = true, unique = false)
	private String temperaturaAv;

	@Column(name = "massaCorporal", nullable = true, precision = 0)
	private double massaCorporal;

	@Column(name = "estatura", nullable = true, precision = 0)
	private double estatura;

	@Column(name = "envergadura", nullable = true, precision = 0)
	private double envergadura;

	@Column(name = "perimetroCint", nullable = true, precision = 0)
	private double perimetroCint;

	@Column(name = "sentarAlcancar", nullable = true, precision = 0)
	private double sentarAlcancar;

	@Column(name = "qtdAbdominal", nullable = true)
	private int qtdAbdominal;

	@Column(name = "corrida6min", nullable = true, precision = 0)
	private double corrida6min;

	@Column(name = "corrida9min", nullable = true, precision = 0)
	private double corrida9min;

	@Column(name = "saltoDistancia", nullable = true, precision = 0)
	private double saltoDistancia;

	@Column(name = "arremessoBall", nullable = true, precision = 0)
	private double arremessoBall;

	@Column(name = "testeQuadrado", nullable = true, precision = 0)
	private double testeQuadrado;	
	
	@Column(name = "corrida20metros", nullable = true)
	private int corrida20metros;	
	
	@Column(name = "gorduraTriciptal", nullable = true)
	private int gorduraTriciptal;	
	
	@Column(name = "gorduraAxilarMed", nullable = true)
	private int gorduraAxilarMed;
	
	@Column(name = "percentualGordura", nullable = true, precision = 0)
	private double percentualGordura;
	
	@Column(name = "imc", nullable = true, precision = 0)
	private double imc;
	
	@Column(name = "statusImc", nullable = true, length = 60)
	private String statusImc;	
	
	@Column(name = "statusCorrida6min", nullable = true, length = 60)
	private String statusCorrida6min;

	@Column(name = "statusFlexibildade", nullable = true, length = 60)
	private String statusFlexibilidade;	

	@Column(name = "statusAbdominal", nullable = true, length = 60)
	private String statusAbdominal;

	@Column(name = "statusFsuperior", nullable = true, length = 60)
	private String statusFsuperior;
	
	@Column(name = "statusFinferior", nullable = true, length = 60)
	private String statusFinferior;

	@Column(name = "statusAgilidade", nullable = true, length = 60)
	private String statusAgilidade;

	@Column(name = "statusVelocidade", nullable = true, length = 60)
	private String statusVelocidade;

	@Column(name = "statusResistencia", nullable = true, length = 60)
	private String statusResistencia;
	
	@Column(name = "statusGordura", nullable = true, length = 60)
	private String statusGordura;
	
	public String getStatusGordura() {
		return statusGordura;
	}

	public void setStatusGordura(String statusGordura) {
		this.statusGordura = statusGordura;
	}

	public double getPercentualGordura() {
		return percentualGordura;
	}

	public void setPercentualGordura(double percentualGordura) {
		this.percentualGordura = percentualGordura;
	}

	public double getImc() {
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public String getStatusImc() {
		return statusImc;
	}

	public void setStatusImc(String statusImc) {
		this.statusImc = statusImc;
	}

	public String getStatusCorrida6min() {
		return statusCorrida6min;
	}

	public void setStatusCorrida6min(String statusCorrida6min) {
		this.statusCorrida6min = statusCorrida6min;
	}

	public String getStatusFlexibilidade() {
		return statusFlexibilidade;
	}

	public void setStatusFlexibilidade(String statusFlexibilidade) {
		this.statusFlexibilidade = statusFlexibilidade;
	}

	public String getStatusAbdominal() {
		return statusAbdominal;
	}

	public void setStatusAbdominal(String statusAbdominal) {
		this.statusAbdominal = statusAbdominal;
	}

	public String getStatusFsuperior() {
		return statusFsuperior;
	}

	public void setStatusFsuperior(String statusFsuperior) {
		this.statusFsuperior = statusFsuperior;
	}

	public String getStatusFinferior() {
		return statusFinferior;
	}

	public void setStatusFinferior(String statusFinferior) {
		this.statusFinferior = statusFinferior;
	}

	public String getStatusAgilidade() {
		return statusAgilidade;
	}

	public void setStatusAgilidade(String statusAgilidade) {
		this.statusAgilidade = statusAgilidade;
	}

	public String getStatusVelocidade() {
		return statusVelocidade;
	}

	public void setStatusVelocidade(String statusVelocidade) {
		this.statusVelocidade = statusVelocidade;
	}

	public String getStatusResistencia() {
		return statusResistencia;
	}

	public void setStatusResistencia(String statusResistencia) {
		this.statusResistencia = statusResistencia;
	}

	public Date getDataAv() {
		return dataAv;
	}

	public void setDataAv(Date dataAv) {
		this.dataAv = dataAv;
	}

	public double getSentarAlcancar() {
		return sentarAlcancar;
	}

	public void setSentarAlcancar(double sentarAlcancar) {
		this.sentarAlcancar = sentarAlcancar;
	}

	public double getArremessoBall() {
		return arremessoBall;
	}

	public void setArremessoBall(double arremessoBall) {
		this.arremessoBall = arremessoBall;
	}

	public int getQtdAbdominal() {
		return qtdAbdominal;
	}

	public void setQtdAbdominal(int qtdAbdominal) {
		this.qtdAbdominal = qtdAbdominal;
	}

	public double getCorrida6min() {
		return corrida6min;
	}

	public void setCorrida6min(double corrida6min) {
		this.corrida6min = corrida6min;
	}

	public double getCorrida9min() {
		return corrida9min;
	}

	public void setCorrida9min(double corrida9min) {
		this.corrida9min = corrida9min;
	}

	public double getSaltoDistancia() {
		return saltoDistancia;
	}

	public void setSaltoDistancia(double saltoDistancia) {
		this.saltoDistancia = saltoDistancia;
	}

	

	public double getTesteQuadrado() {
		return testeQuadrado;
	}

	public void setTesteQuadrado(double testeQuadrado) {
		this.testeQuadrado = testeQuadrado;
	}

	public int getCorrida20metros() {
		return corrida20metros;
	}

	public void setCorrida20metros(int corrida20metros) {
		this.corrida20metros = corrida20metros;
	}

	public int getGorduraTriciptal() {
		return gorduraTriciptal;
	}

	public void setGorduraTriciptal(int gorduraTriciptal) {
		this.gorduraTriciptal = gorduraTriciptal;
	}

	public int getGorduraAxilarMed() {
		return gorduraAxilarMed;
	}

	public void setGorduraAxilarMed(int gorduraAxilarMed) {
		this.gorduraAxilarMed = gorduraAxilarMed;
	}

	public void setMassaCorporal(double massaCorporal) {
		this.massaCorporal = massaCorporal;
	}

	public double getEnvergadura() {
		return envergadura;
	}

	public void setEnvergadura(double envergadura) {
		this.envergadura = envergadura;
	}

	public double getPerimetroCint() {
		return perimetroCint;
	}

	public void setPerimetroCint(double perimetroCint) {
		this.perimetroCint = perimetroCint;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public String getTempoPratica() {
		return tempoPratica;
	}

	public void setTempoPratica(String tempoPratica) {
		this.tempoPratica = tempoPratica;
	}

	public String getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(String deficiencia) {
		this.deficiencia = deficiencia;
	}

	public String getHoraAv() {
		return horaAv;
	}

	public void setHoraAv(String horaAv) {
		this.horaAv = horaAv;
	}

	public String getTemperaturaAv() {
		return temperaturaAv;
	}

	public void setTemperaturaAv(String temperaturaAv) {
		this.temperaturaAv = temperaturaAv;
	}

	public double getMassaCorporal() {
		return massaCorporal;
	}

	public void setMassaCorporal(float massaCorporal) {
		this.massaCorporal = massaCorporal;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFreqSemanal() {
		return freqSemanal;
	}

	public void setFreqSemanal(String freqSemanal) {
		this.freqSemanal = freqSemanal;
	}

	public String getDuracaoMediaSecao() {
		return duracaoMediaSecao;
	}

	public void setDuracaoMediaSecao(String duracaoMediaSecao) {
		this.duracaoMediaSecao = duracaoMediaSecao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEsporte() {
		return esporte;
	}

	public void setEsporte(String esporte) {
		this.esporte = esporte;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Date getDataN() {
		return dataN;
	}

	public void setDataN(Date dataN) {
		this.dataN = dataN;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	

}
