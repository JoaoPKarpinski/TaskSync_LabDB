package com.labBD.api.model.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rua;

	private String numero;

	private String bairro;

	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;

	public Endereco(){
	}

	public Endereco(Long id, String rua, String numero, String bairro, Departamento departamento) {
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.departamento = departamento;
	}

	public Endereco(Integer id){
		this.id = Long.valueOf(id.longValue());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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
		Endereco endereco = (Endereco) o;
		return Objects.equals(id, endereco.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, rua, numero, bairro, departamento);
	}

	@Override
	public String toString() {
		return "Endereco{" +
				"id=" + id +
				", rua='" + rua + '\'' +
				", numero='" + numero + '\'' +
				", bairro='" + bairro + '\'' +
				", departamento=" + departamento +
				'}';
	}
}
