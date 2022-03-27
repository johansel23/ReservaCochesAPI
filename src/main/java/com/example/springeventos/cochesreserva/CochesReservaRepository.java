package com.example.springeventos.cochesreserva;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CochesReservaRepository extends JpaRepository<CocheReserva, Integer> {

    //Query para obtener las reservas de un usuario 
    @Query("SELECT cr FROM CocheReserva cr WHERE cr.id_usuario = :id_usuario")
    List<CocheReserva> findByIdUsuario(Integer id_usuario);

    
}
