package com.example.springeventos.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.springeventos.coches.Coche;
import com.example.springeventos.marcas.Marca;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_modelo;
    @NotEmpty
    private String nombre_modelo;
    @NotNull
    private Integer id_marca;      
    
    @ManyToOne()
	@JoinColumn(name = "id_marca", insertable = false, updatable = false)
	private Marca marca;

    @JsonBackReference
    @OneToMany(targetEntity = Coche.class, mappedBy = "id_modelo", orphanRemoval = false, fetch = FetchType.LAZY)
	private List<Coche> coches;

}
