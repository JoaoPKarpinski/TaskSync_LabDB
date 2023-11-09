package com.labBD.api.controller;

import com.labBD.api.exception.RecordNotFoundException;
import com.labBD.api.model.entities.Departamento;
import com.labBD.api.model.entities.Supervisor;
import com.labBD.api.model.repository.DepartamentoRepository;
import com.labBD.api.model.repository.SupervisorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DepartamentoController {

    DepartamentoRepository repo;
    SupervisorRepository supRepo;

    public DepartamentoController(DepartamentoRepository repo, SupervisorRepository supRepo){
        this.repo = repo;
        this.supRepo = supRepo;
    }

    @PostMapping(path = "/departamento")
    public Departamento insertDepartamento(@RequestBody Departamento novoDepartamento){
        System.out.println(novoDepartamento);
        return this.repo.save(novoDepartamento);
    }

    @GetMapping(path = "/departamento/byGerente")
    public Departamento getByGerenteId(@RequestParam Integer idGerente){
        Supervisor sup = this.supRepo.findByGerenteId(idGerente);
        Departamento depto = this.repo.findBySupervisorId(sup.getId());
        System.out.println(depto);
        return depto;//this.repo.findById(id);
    }

    @GetMapping(path = "/departamento/bySupervisor")
    public Departamento getBySupervisorId(@RequestParam Long idSupervisor){
        Departamento depto = this.repo.findBySupervisorId(idSupervisor);
        System.out.println(depto);
        return depto;//this.repo.findById(id);
    }

    @GetMapping(path = "/departamento")
    public List<Departamento> getAll(){
        return this.repo.findAll();
    }

    @GetMapping(path = "/departamento/{id}")
    public Departamento getById(@PathVariable Long id){
        return this.repo.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @PutMapping(path = "/departamento/{id}")
    public Departamento putDepartamento(@RequestBody Departamento newDepartamento, @PathVariable Long id){
        Departamento oldDepartamento = this.repo.findById(id).isPresent() ? this.repo.findById(id).get() : new Departamento();
        newDepartamento.setId(oldDepartamento.getId());
        return this.repo.save(newDepartamento);
    }

    @DeleteMapping("/departamento/{id}")
    void deleteDepartamento(@PathVariable Long id) {
        this.repo.deleteById(id);
    }

}
