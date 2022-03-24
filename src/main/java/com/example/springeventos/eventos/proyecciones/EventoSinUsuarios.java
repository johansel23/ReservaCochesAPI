package com.example.springeventos.eventos.proyecciones;

import java.time.LocalDate;

public interface EventoSinUsuarios {
    int getId();
    String getTitulo();
    String getDescripcion();
    double getPrecio();
    LocalDate getFecha();
    String getImagen();

    void setImagen(String imagen);
}
