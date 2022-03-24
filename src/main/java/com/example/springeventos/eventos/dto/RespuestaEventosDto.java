package com.example.springeventos.eventos.dto;

import java.util.List;

import com.example.springeventos.eventos.Evento;
import com.example.springeventos.eventos.proyecciones.EventoSinUsuarios;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RespuestaEventosDto {
    private List<Evento> eventos;
}
