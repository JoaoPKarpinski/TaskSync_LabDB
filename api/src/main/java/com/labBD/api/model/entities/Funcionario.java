package com.labBD.api.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

import java.sql.Date;
import java.util.Objects;

@MappedSuperclass
public class Funcionario {

	@ManyToOne
	@JoinColumn(name = "gerente_id")
	private Gerente gerente;
	private String primeiroNome;

	private String ultimoNome;

	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataNascimento;

	private double salario;

	private char sexo;

	private String cpf;

	public Funcionario(){
	}

	public Funcionario(Gerente gerente, String primeiroNome, String ultimoNome, Date dataNascimento, double salario, char sexo, String cpf) {
		this.gerente = gerente;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.sexo = sexo;
		this.cpf = cpf;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gerente, primeiroNome, ultimoNome, dataNascimento, salario, sexo, cpf);
	}

	@Override
	public String toString() {
		return "Funcionario{" +
				"gerente=" + gerente +
				", primeiroNome='" + primeiroNome + '\'' +
				", ultimoNome='" + ultimoNome + '\'' +
				", dataNascimento=" + dataNascimento +
				", salario=" + salario +
				", sexo=" + sexo +
				", cpf='" + cpf + '\'' +
				'}';
	}
}
