package com.example.springeventos.cochesreserva;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CochesReservaService {
    private final @NonNull CochesReservaRepository cocheReservaRepo;
    
    //Metodo para obtener todas las reservas
    public List<CocheReserva> findAll(){

        return cocheReservaRepo.findAll();
    }
    //Metodo para obtener una reserva por el id
    public CocheReserva findById(int id){
        return cocheReservaRepo.findById(id).orElse(null);
    }
    //Metodo para obtener las reservas de un usuario
    public List<CocheReserva> findByIdUsuario(int id_usuario){

        return cocheReservaRepo.findByIdUsuario(id_usuario);
    }
    //Metodo para insertar una nueva reserva
    public CocheReserva insert(CocheReserva cocheReserva) {
        return cocheReservaRepo.save(cocheReserva);
    }
    //Metodo para actualizar una reserva
    public CocheReserva update(CocheReserva cocheReserva, int id) {
        if(cocheReservaRepo.existsById(id)){
            cocheReserva.setId_reserva(id);
            return cocheReservaRepo.save(cocheReserva);
        }
        return null; // No existe
    }
    
    //Metodo para eliminar una reserva
    public void delete(int id){
        cocheReservaRepo.deleteById(id);
    }
}
