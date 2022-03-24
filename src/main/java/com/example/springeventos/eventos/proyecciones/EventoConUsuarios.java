package com.example.springeventos.eventos.proyecciones;

import java.util.List;

import com.example.springeventos.usuarios.proyecciones.UsuarioSinEventos;

public interface EventoConUsuarios extends EventoSinUsuarios {
    List<UsuarioSinEventos> getAsistentes();
}
