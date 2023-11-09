package com.labBD.api.model.repository;
import com.labBD.api.model.entities.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
    public Projeto findByDepartamentoId(Long idGerente);
}
