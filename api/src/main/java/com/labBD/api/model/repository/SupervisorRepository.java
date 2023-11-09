package com.labBD.api.model.repository;
import com.labBD.api.model.entities.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SupervisorRepository extends JpaRepository<Supervisor, Long>{
    public Supervisor findByGerenteId(Integer idGerente);
}
