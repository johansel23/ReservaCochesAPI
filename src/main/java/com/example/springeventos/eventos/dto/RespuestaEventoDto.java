package com.example.springeventos.eventos.dto;

import com.example.springeventos.eventos.Evento;
import com.example.springeventos.eventos.proyecciones.EventoConUsuarios;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RespuestaEventoDto {
    private EventoConUsuarios evento;
}
