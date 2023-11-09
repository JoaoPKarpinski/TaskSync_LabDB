package com.labBD.api.model.entities;

import com.labBD.api.model.entities.Funcionario;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Colaborador extends Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany
	private List<Projeto> projetos;

	public Colaborador(){
	}

	public Colaborador(Integer id){
		this.id = Long.valueOf(id.longValue());
	}

	public Colaborador(Long id, List<Projeto> projetos) {
		this.id = id;
		this.projetos = projetos;
	}

	public Colaborador(Gerente gerente, String primeiroNome, String ultimoNome, Date dataNascimento, double salario, char sexo, String cpf, Long id, List<Projeto> projetos) {
		super(gerente, primeiroNome, ultimoNome, dataNascimento, salario, sexo, cpf);
		this.id = id;
		this.projetos = projetos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Colaborador that = (Colaborador) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, projetos);
	}

	@Override
	public String toString() {
		return "Colaborador{" +
				"id=" + id +
				", projetos=" + projetos +
				'}';
	}
}
