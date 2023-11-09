package com.labBD.api.controller;

import com.labBD.api.exception.RecordNotFoundException;
import com.labBD.api.model.entities.Supervisor;
import com.labBD.api.model.repository.DepartamentoRepository;
import com.labBD.api.model.repository.SupervisorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SupervisorController {
    SupervisorRepository repo;
    DepartamentoRepository depRepo;

    public SupervisorController(SupervisorRepository repo, DepartamentoRepository depRepo) {
        this.repo = repo;
        this.depRepo = depRepo;
    }

    @PostMapping(path = "/supervisor")
    public Supervisor insertSupervisor(@RequestBody Supervisor novoSupervisor){
        System.out.println(novoSupervisor);
        return this.repo.save(novoSupervisor);
    }

    @GetMapping(path = "/supervisor/byGerente")
    public Supervisor getByGerenteId(@RequestParam Integer idGerente){
        Supervisor supervisor = this.repo.findByGerenteId(idGerente);
        System.out.println(supervisor);
        return supervisor;//this.repo.findById(id);
    }

    @GetMapping(path = "/supervisor")
    public List<Supervisor> getAll(){
        return this.repo.findAll();
    }

    @GetMapping(path = "/supervisor/{id}")
    public Supervisor getById(@PathVariable Long id){
        return this.repo.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @PutMapping(path = "/supervisor/{id}")
    public Supervisor putSupervisor(@RequestBody Supervisor newSupervisor, @PathVariable Long id){
        Supervisor oldSupervisor = this.repo.findById(id).isPresent() ? this.repo.findById(id).get() : new Supervisor();
        newSupervisor.setId(oldSupervisor.getId());
        return this.repo.save(newSupervisor);
    }

    @DeleteMapping("/supervisor/{id}")
    void deleteSupervisor(@PathVariable Long id) {
        this.repo.deleteById(id);
    }

}
