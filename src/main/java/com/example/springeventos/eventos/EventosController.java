package com.example.springeventos.eventos;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.example.springeventos.eventos.dto.RespuestaEventoDto;
import com.example.springeventos.eventos.dto.RespuestaEventosDto;
import com.example.springeventos.eventos.proyecciones.EventoConUsuarios;
import com.example.springeventos.eventos.proyecciones.EventoSinUsuarios;

import org.springframework.dao.EmptyResultDataAccessException;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/eventos")
public class EventosController {
    private final @NonNull EventosService evService;

    // @GetMapping
    // public RespuestaEventosDto findAll() {
    //     List<EventoSinUsuarios> eventos = evService.findAll();
    //     List<Evento> eventos2 = eventos.stream().map(e -> {
    //         return new Evento(e.getId(), e.getTitulo(), e.getDescripcion(), 
    //             e.getPrecio(), e.getFecha(), ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() + "/" + e.getImagen(), null);
    //     }).collect(Collectors.toList());
    //     return new RespuestaEventosDto(eventos2);
    // }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaEventoDto> findById(@PathVariable int id) {
        EventoConUsuarios e = evService.findById(id);
        if(e == null) {
            return ResponseEntity.notFound().build();
        } else {
            e.setImagen(ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() + "/" + e.getImagen());
            return ResponseEntity.ok().body(new RespuestaEventoDto(e));
        }
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Evento insert(@RequestBody @Valid Evento evento) {
        Evento e = evService.insert(evento);
        e.setImagen(ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() + "/" + e.getImagen());
        return e;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> update(@RequestBody @Valid Evento evento, @PathVariable int id) {
        Evento e = evService.update(evento, id);
        if(e == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(e);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try{
            evService.delete(id);
            return ResponseEntity.noContent().build();
        } catch(EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
