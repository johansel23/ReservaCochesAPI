package com.example.springeventos.marcas;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RestController
@RequestMapping("/marcas")
public class MarcasController {
    private final @NonNull MarcasService marcaService;
    
    
    @GetMapping
    public List<Marca> findAll() {
        return marcaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> findById(@PathVariable int id) {
        Marca m = marcaService.findById(id);
        if(m == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(m);
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Marca insert(@RequestBody Marca marca){
        return marcaService.insert(marca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> update(@RequestBody Marca marca, @PathVariable int id){
        Marca m = marcaService.update(marca, id);
        if(m == null){
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok().body(m);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
            marcaService.delete(id);
        
    }

    
    
    
    
}
