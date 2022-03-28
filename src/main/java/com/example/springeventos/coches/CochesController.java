package com.example.springeventos.coches;

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
@RequestMapping("/coches")
public class CochesController {
    private final @NonNull CochesService cocheService;

    @GetMapping
    public List<Coche> findAll(){
        return cocheService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coche> findById(@PathVariable int id) {
        Coche co = cocheService.findById(id);
        if(co == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(co);
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Coche insert(@RequestBody Coche coche){
        return cocheService.insert(coche);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coche> update(@RequestBody Coche coche, @PathVariable int id){
        Coche co = cocheService.update(coche, id);
        if(co == null){
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok().body(co);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
            cocheService.delete(id);
        
    }
}
