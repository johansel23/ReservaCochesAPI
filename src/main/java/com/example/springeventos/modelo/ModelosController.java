package com.example.springeventos.modelo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/modelos")
public class ModelosController {
    private final @NonNull ModelosService modeloService;
    
    @GetMapping
    public List<Modelo> findAll() {
        return modeloService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> findById(@PathVariable int id) {
        Modelo mo = modeloService.findById(id);
        if(mo == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(mo);
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Modelo insert(@RequestBody Modelo modelo){
        return modeloService.insert(modelo);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Modelo> update(@RequestBody Modelo modelo, @PathVariable int id){
        Modelo mo = modeloService.update(modelo, id);
        if(mo == null){
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok().body(mo);
        }
    }
    

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
            modeloService.delete(id);
        
    }
}
