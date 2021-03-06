package com.example.springeventos.usuarios;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.example.springeventos.cochesreserva.CocheReserva;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null
    private Integer id;
    @NotNull(message = "El nombre es obligatorio")
    @Size(min = 4)
    private String nombre;
    @NotNull
    @Email
    private String correo;
    @NotEmpty
    private String password;
    @NotNull
    private Boolean administrador;


    @JsonBackReference
    @OneToMany(targetEntity = CocheReserva.class, mappedBy = "id_usuario", orphanRemoval = false, fetch = FetchType.LAZY)
	private List<CocheReserva> cocheReserva;
}
