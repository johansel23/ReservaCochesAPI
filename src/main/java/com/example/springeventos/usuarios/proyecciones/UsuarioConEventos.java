package com.example.springeventos.usuarios.proyecciones;

import java.util.List;

import com.example.springeventos.eventos.proyecciones.EventoSinUsuarios;

public interface UsuarioConEventos extends UsuarioSinEventos {
    List<EventoSinUsuarios> getEventos();
}
