package com.example.springeventos.usuarios;

import java.util.List;

import javax.validation.Valid;

import com.example.springeventos.usuarios.dto.AsistirEventoDto;
import com.example.springeventos.usuarios.proyecciones.UsuarioConEventos;
import com.example.springeventos.usuarios.proyecciones.UsuarioSinEventos;

import org.springframework.dao.EmptyResultDataAccessException;
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

    @PostMapping("/{idUsuario}/eventos")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void asistirEvento(@PathVariable int idUsuario, @RequestBody AsistirEventoDto asistencia) {
        usuService.asistirEvento(idUsuario, asistencia.getEvento());
    }
}
