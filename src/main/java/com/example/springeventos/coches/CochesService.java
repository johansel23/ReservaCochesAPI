package com.example.springeventos.coches;

import java.util.List;

import com.example.springeventos.utils.ImageUtils;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CochesService {
    private final @NonNull CochesRepository cocheRepo;
    private final @NonNull ImageUtils imgUtils;

    public List<Coche> findAll(){
        
        return cocheRepo.findAll();
    }

    public Coche findById(int id){

        return cocheRepo.findById(id).orElse(null);

    }

    // public Coche insert(Coche co){
    //     return cocheRepo.save(co);
    // }

    public Coche insert(Coche c) {
        String ruta = imgUtils.saveImageBase64("coches", c.getImage());
        c.setImage(ruta);
        return cocheRepo.save(c);
    }
    // public Evento insert(Evento e) {
    //     String ruta = imgUtils.saveImageBase64("eventos", e.getImagen());
    //     e.setImagen(ruta);
    //     return eventRepo.save(e);
    // }

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
