package com.labBD.api.model.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@OneToMany
	private List<Projeto> projeto;

	@OneToOne
	@JoinColumn(name = "supervisor_id")
	private Supervisor supervisor;

	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	public Departamento(Long id, String nome, List<Projeto> projeto, Supervisor supervisor, Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.projeto = projeto;
		this.supervisor = supervisor;
		this.endereco = endereco;
	}

	public Departamento(){}

	public Departamento(Integer id){
		this.id = Long.valueOf(id.longValue());
	}

	//Long l = Long.valueOf(i.longValue());

	/*
	@JsonCreator
	public Departamento(@JsonProperty("departamento") Integer id){
		this.id = Long.valueOf(id.longValue());
	}
	*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Projeto> getProjeto() {
		return projeto;
	}

	public void setProjeto(List<Projeto> projeto) {
		this.projeto = projeto;
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Departamento that = (Departamento) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, projeto, supervisor, endereco);
	}

	@Override
	public String toString() {
		return "Departamento{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", projeto=" + projeto +
				", supervisor=" + supervisor +
				", endereco=" + endereco +
				'}';
	}
}
