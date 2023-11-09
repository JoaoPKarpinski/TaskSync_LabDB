package com.labBD.api.controller;

import com.labBD.api.exception.RecordNotFoundException;
import com.labBD.api.model.entities.Departamento;
import com.labBD.api.model.entities.Projeto;
import com.labBD.api.model.entities.Supervisor;
import com.labBD.api.model.repository.DepartamentoRepository;
import com.labBD.api.model.repository.ProjetoRepository;
import com.labBD.api.model.repository.SupervisorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProjetoController {

    ProjetoRepository repo;
    DepartamentoRepository depRepo;
    SupervisorRepository supRepo;

    public ProjetoController(ProjetoRepository repo, DepartamentoRepository depRepo, SupervisorRepository supRepo) {
        this.repo = repo;
        this.depRepo = depRepo;
        this.supRepo = supRepo;
    }

    @PostMapping(path = "/projeto")
    public Projeto insertProjeto(@RequestBody Projeto novoProjeto){
        System.out.println(novoProjeto);
        return this.repo.save(novoProjeto);
    }

    @GetMapping(path = "/projeto/byGerente")
    public Projeto getByGerenteId(@RequestParam Integer idGerente){
        Supervisor sup = this.supRepo.findByGerenteId(idGerente);
        Departamento depto = this.depRepo.findBySupervisorId(sup.getId());
        Projeto projeto = this.repo.findByDepartamentoId(depto.getId());
        System.out.println(projeto);
        return projeto;//this.repo.findById(id);
    }

    @GetMapping(path = "/projeto")
    public List<Projeto> getAll(){
        return this.repo.findAll();
    }

    @GetMapping(path = "/projeto/{id}")
    public Projeto getById(@PathVariable Long id){
        return this.repo.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @PutMapping(path = "/projeto/{id}")
    public Projeto putProjeto(@RequestBody Projeto newProjeto, @PathVariable Long id){
        Projeto oldProjeto = this.repo.findById(id).isPresent() ? this.repo.findById(id).get() : new Projeto();
        newProjeto.setId(oldProjeto.getId());
        return this.repo.save(newProjeto);
    }

    @DeleteMapping("/projeto/{id}")
    void deleteProjeto(@PathVariable Long id) {
        this.repo.deleteById(id);
    }

}
