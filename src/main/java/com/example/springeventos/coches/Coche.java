package com.example.springeventos.coches;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.springeventos.modelo.Modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_coche;
    @NotNull
    private Integer id_modelo;
    @NotNull
    private Integer anyo;
    @NotEmpty
    private String color;
    @NotEmpty
    private String combustible;
    
    private Boolean transmision;
    @NotNull
    private Integer precio;
    @NotEmpty
    private String image;

    private Boolean is_disponible;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_modelo", insertable = false, updatable = false)
	private Modelo modelo;

}
