package com.labBD.api.model.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String objetivo;

	private String nome;

	@ManyToMany
	private List<Colaborador> colaboradores;

	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;

	public Projeto(){
	}

	public Projeto(Long id, String objetivo, String nome, List<Colaborador> colaboradores, Departamento departamento) {
		this.id = id;
		this.objetivo = objetivo;
		this.nome = nome;
		this.colaboradores = colaboradores;
		this.departamento = departamento;
	}

	public Projeto(Integer id){
		this.id = Long.valueOf(id.longValue());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Colaborador> getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(List<Colaborador> colaboradores) {
		this.colaboradores = colaboradores;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Projeto projeto = (Projeto) o;
		return Objects.equals(id, projeto.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, objetivo, nome, colaboradores, departamento);
	}

	@Override
	public String toString() {
		return "Projeto{" +
				"id=" + id +
				", objetivo='" + objetivo + '\'' +
				", nome='" + nome + '\'' +
				", colaboradores=" + colaboradores +
				", departamento=" + departamento +
				'}';
	}
}
