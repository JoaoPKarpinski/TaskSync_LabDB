package com.labBD.api.controller;

import com.labBD.api.exception.RecordNotFoundException;
import com.labBD.api.model.repository.GerenteRepository;
import com.labBD.api.model.entities.Gerente;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class GerenteController {
    GerenteRepository repo;

    public GerenteController(GerenteRepository repo){
        this.repo = repo;
    }

    
    //@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(path = "/gerente")
    public Gerente inserirNovoGerente(@RequestBody Gerente novoGerente){
        System.out.println(novoGerente);
        return this.repo.save(novoGerente);
    }

    @GetMapping(path = "/gerente/{id}")
    public Gerente getGerenteById(@PathVariable Integer id){
        return this.repo.findById(id).orElseThrow(() -> new RecordNotFoundException(id));//this.repo.findById(id);
    }

    @GetMapping(path = "/gerente")
    public List<Gerente> getAll(){
        return this.repo.findAll();
    }

    
    //@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping(path = "/gerente/{id}")
    public Gerente putGerente(@RequestBody Gerente newGerente, @PathVariable Integer id){
        Gerente oldGerente = this.repo.findById(id).isPresent() ? this.repo.findById(id).get() : new Gerente();
        oldGerente.setCpf(newGerente.getCpf());
        oldGerente.setPrimeiroNome(newGerente.getPrimeiroNome());
        oldGerente.setUltimoNome(newGerente.getUltimoNome());
        oldGerente.setEmail(newGerente.getEmail());
        System.out.println(oldGerente);
        return this.repo.save(oldGerente);
    }
    
    @DeleteMapping("/gerente/{id}")
    void deleteGerente(@PathVariable Integer id) {
        this.repo.deleteById(id);
    }
}
