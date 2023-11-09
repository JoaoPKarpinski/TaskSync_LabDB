package com.labBD.api.model.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Supervisor extends Funcionario{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Supervisor(){
	}
	public Supervisor(Long id, Departamento departamento) {
		this.id = id;
		this.departamento = departamento;
	}

	public Supervisor(Integer id){
		this.id = Long.valueOf(id.longValue());
	}

	public Supervisor(Gerente gerente, String primeiroNome, String ultimoNome, Date dataNascimento, double salario, char sexo, String cpf, Long id, Departamento departamento) {
		super(gerente, primeiroNome, ultimoNome, dataNascimento, salario, sexo, cpf);
		this.id = id;
		this.departamento = departamento;
	}
}
