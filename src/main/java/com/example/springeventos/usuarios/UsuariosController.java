package com.example.springeventos.usuarios;

import java.util.List;

import javax.validation.Valid;

import com.example.springeventos.usuarios.proyecciones.UsuarioConEventos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    private final @NonNull UsuariosService usuService;

    @GetMapping
    public List<Usuario> findAll() {
        return usuService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioConEventos> findById(@PathVariable int id) {
        UsuarioConEventos e = usuService.findById(id);
        if(e == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@RequestBody @Valid Usuario evento, @PathVariable int id) {
        Usuario e = usuService.update(evento, id);
        if(e == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(e);
        }
    }

}
