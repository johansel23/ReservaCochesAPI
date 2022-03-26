package com.example.springeventos.cochesreserva;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.example.springeventos.coches.Coche;
import com.example.springeventos.usuarios.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class CocheReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reserva;

    @NotNull
    private Integer id_coche;

    @NotNull
    private LocalDate fecha;

    @NotNull
    private Integer id_usuario;

    @NotNull
    private Boolean is_reservado;

    @ManyToOne()
    @JoinColumn(name = "id_coche", insertable = false, updatable = false)
	private Coche coche;

    @ManyToOne()
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	private Usuario usuario;





}
