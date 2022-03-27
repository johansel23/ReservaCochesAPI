package com.example.springeventos.cochesreserva;

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
@RequestMapping("/reservas")
public class CochesReservaController {
    private final @NonNull CochesReservaService cocheReservaService;

    @GetMapping
    public List<CocheReserva> findAll(){
        return cocheReservaService.findAll();
    }

    @GetMapping("/idusuario/{id_usuario}")
    public List<CocheReserva> findByIdUsuario(@PathVariable int id_usuario){
        return cocheReservaService.findByIdUsuario(id_usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CocheReserva> findById(@PathVariable int id){
        CocheReserva cocheReserva = cocheReservaService.findById(id);
        if(cocheReserva == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok().body(cocheReserva);
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CocheReserva insert(@RequestBody CocheReserva cocheReserva){
        return cocheReservaService.insert(cocheReserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CocheReserva> update(@RequestBody CocheReserva cocheReserva, @PathVariable int id){
        CocheReserva cocheRe = cocheReservaService.update(cocheReserva, id);
        if(cocheRe == null){
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok().body(cocheRe);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
            cocheReservaService.delete(id);
        
    }
    
}
