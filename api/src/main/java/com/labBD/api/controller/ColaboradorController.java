package com.labBD.api.controller;

import com.labBD.api.exception.RecordNotFoundException;
import com.labBD.api.model.entities.Colaborador;
import com.labBD.api.model.entities.Gerente;
import com.labBD.api.model.repository.ColaboradorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ColaboradorController {
    ColaboradorRepository repo;

    public ColaboradorController(ColaboradorRepository repo){
        this.repo = repo;
    }

    //@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(path = "/colaborador")
    public Colaborador insertColaborador(@RequestBody Colaborador novoColaborador){
        System.out.println(novoColaborador);
        return this.repo.save(novoColaborador);
    }

    @GetMapping(path = "/colaborador/byGerente")
    public Colaborador getByGerenteId(@RequestParam Integer idGerente){
        Colaborador c = this.repo.findByGerenteId(idGerente);
        System.out.println(c);
        return c;//this.repo.findById(id);
    }

    @GetMapping(path = "/colaborador")
    public List<Colaborador> getAll(){
        return this.repo.findAll();
    }

    @GetMapping(path = "/colaborador/{id}")
    public Colaborador getById(@PathVariable Long id){
        return this.repo.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @PutMapping(path = "/colaborador/{id}")
    public Colaborador putColaborador(@RequestBody Colaborador newColaborador, @PathVariable Long id){
        Colaborador oldColaborador = this.repo.findById(id).isPresent() ? this.repo.findById(id).get() : new Colaborador();
        newColaborador.setId(oldColaborador.getId());
        return this.repo.save(newColaborador);
    }

    @DeleteMapping("/colaborador/{id}")
    void deleteColaborador(@PathVariable Long id) {
        this.repo.deleteById(id);
    }

}