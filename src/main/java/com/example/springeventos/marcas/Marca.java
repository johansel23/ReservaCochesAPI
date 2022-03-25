package com.example.springeventos.marcas;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.example.springeventos.modelo.Modelo;

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
    

    //Relacion uno a muchos, el cual se relaciona con modelo.
    @OneToMany()
    @JoinColumn(name = "id_marca")
    private List<Modelo> modelo;
    
    
}
