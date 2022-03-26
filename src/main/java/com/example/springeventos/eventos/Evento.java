package com.example.springeventos.eventos;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;

import com.example.springeventos.usuarios.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null
    private Integer id;
    @NotEmpty
    private String titulo;
    @NotEmpty
    private String descripcion;
    @NotNull
    @Positive
    private Double precio;
    @NotNull
    private LocalDate fecha; // yyyy-mm-dd
    @NotEmpty
    private String imagen;

    // @ManyToMany(mappedBy = "eventos")
    // List<Usuario> asistentes;
}

