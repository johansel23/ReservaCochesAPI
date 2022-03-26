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

    public Coche findById(int id){

        return cocheRepo.findById(id).orElse(null);

    }

    public Coche insert(Coche co){
        return cocheRepo.save(co);
    }

    public Coche update(Coche coche,int id ){
        if(cocheRepo.existsById(id)){
            coche.setId_coche(id);
            return cocheRepo.save(coche);
        }
        return null;
    }

    public void delete(int id){
        cocheRepo.deleteById(id); 
    }
}
