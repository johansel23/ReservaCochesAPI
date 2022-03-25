package com.example.springeventos.modelo;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ModelosService {
    private final @NonNull ModelosRepository modeloRepo;
    
    public List<Modelo> findAll() {

        return modeloRepo.findAll();

    }

    public Modelo findById(int id) {
        return modeloRepo.findById(id).orElse(null);
    }

    public Modelo insert(Modelo mo) {
        return modeloRepo.save(mo);
    }
    
    public Modelo update(Modelo modelo, int id) {
        if(modeloRepo.existsById(id)){
            modelo.setId_modelo(id);
            return modeloRepo.save(modelo);
        }
        return null; // No existe
    }
    

    public void delete(int id) {
        modeloRepo.deleteById(id);
    }
}
