package com.labBD.api.model.repository;
import com.labBD.api.model.entities.Colaborador;
import com.labBD.api.model.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{
    public Departamento findBySupervisorId(Long idSupervidor);
}
