package com.example.springeventos.marcas;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MarcasService {
    private final @NonNull MarcasRepository marcaRepo; 
    
    public List<Marca> findAll() {

        return marcaRepo.findAll();

    }

    public Marca findById(int id) {
        return marcaRepo.findById(id).orElse(null);
    }

    public Marca insert(Marca m) {
        return marcaRepo.save(m);
    }

    public Marca update(Marca marca, int id) {
        if(marcaRepo.existsById(id)){
            marca.setId_marca(id);
            return marcaRepo.save(marca);
        }
        return null; // No existe
    }

    public void delete(int id) {
        marcaRepo.deleteById(id);
    }
        
}
