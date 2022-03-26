package com.example.springeventos.cochesreserva;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CochesReservaRepository extends JpaRepository<CocheReserva, Integer> {
    
}
