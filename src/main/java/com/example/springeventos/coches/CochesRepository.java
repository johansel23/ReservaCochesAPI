package com.example.springeventos.coches;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CochesRepository extends JpaRepository<Coche, Integer> {
    
}
