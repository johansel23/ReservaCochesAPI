package com.example.springeventos.cochesreserva;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CochesReservaService {
    private final @NonNull CochesReservaRepository cocheReservaRepo;
    
    public List<CocheReserva> findAll(){

        return cocheReservaRepo.findAll();
    }

    public CocheReserva findById(int id){
        return cocheReservaRepo.findById(id).orElse(null);
    }
    
    public CocheReserva insert(CocheReserva cocheReserva) {
        return cocheReservaRepo.save(cocheReserva);
    }

    public CocheReserva update(CocheReserva cocheReserva, int id) {
        if(cocheReservaRepo.existsById(id)){
            cocheReserva.setId_reserva(id);
            return cocheReservaRepo.save(cocheReserva);
        }
        return null; // No existe
    }

    public void delete(int id){
        cocheReservaRepo.deleteById(id);
    }
}
