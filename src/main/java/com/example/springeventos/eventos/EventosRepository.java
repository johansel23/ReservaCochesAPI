package com.example.springeventos.eventos;

import java.util.List;

import com.example.springeventos.eventos.proyecciones.EventoConUsuarios;
import com.example.springeventos.eventos.proyecciones.EventoSinUsuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends JpaRepository<Evento, Integer>  {
    List<EventoSinUsuarios> findBy();
    EventoConUsuarios findWithUsuariosById(Integer id);
    EventoSinUsuarios findWithoutUsuariosById(Integer id);
}
