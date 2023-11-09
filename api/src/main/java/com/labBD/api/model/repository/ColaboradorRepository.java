package com.labBD.api.model.repository;
import com.labBD.api.model.entities.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ColaboradorRepository extends JpaRepository<Colaborador, Long>{
    public Colaborador findByGerenteId(Integer idGerente);
}
