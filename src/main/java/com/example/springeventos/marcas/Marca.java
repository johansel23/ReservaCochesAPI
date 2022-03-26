package com.example.springeventos.marcas;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.example.springeventos.modelo.Modelo;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_marca;
    @NotEmpty
    private String nombre_marca;
    
    @JsonBackReference
    @OneToMany(targetEntity = Modelo.class, mappedBy = "id_marca", orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Modelo> modelos;
    
}
