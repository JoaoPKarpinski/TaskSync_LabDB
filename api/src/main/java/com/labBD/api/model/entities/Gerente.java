package com.labBD.api.model.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Gerente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String primeiroNome;
    private String ultimoNome;
    private String cpf;
    private Character sexo;

    @OneToMany
    private List<Colaborador> funcionarios;

    public Gerente(){
    }

    public Gerente(String email, String primeiroNome, String ultimoNome, String cpf, Character sexo, List<Colaborador> funcionarios) {
        this.email = email;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.funcionarios = funcionarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public List<Colaborador> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Colaborador> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Gerente{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", primeiroNome='" + primeiroNome + '\'' +
                ", ultimoNome='" + ultimoNome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", sexo=" + sexo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Gerente gerente = (Gerente) o;
        return Objects.equals(id, gerente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, primeiroNome, ultimoNome, cpf, sexo);
    }

    public Gerente(Integer id) {
        this.id = id;
    }

}
