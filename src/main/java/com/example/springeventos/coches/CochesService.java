package com.example.springeventos.coches;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CochesService {
    private final @NonNull CochesRepository cocheRepo;

    public List<Coche> findAll(){
        
        return cocheRepo.findAll();
    }
}
