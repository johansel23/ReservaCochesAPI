package com.example.springeventos.eventos;

import java.util.List;

import com.example.springeventos.eventos.proyecciones.EventoConUsuarios;
import com.example.springeventos.eventos.proyecciones.EventoSinUsuarios;
import com.example.springeventos.utils.ImageUtils;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EventosService {
    private final @NonNull EventosRepository eventRepo;
    private final @NonNull ImageUtils imgUtils;

    public List<EventoSinUsuarios> findAll() {
        return eventRepo.findBy();
    }

    public EventoConUsuarios findById(int id) {
        return eventRepo.findWithUsuariosById(id);
    }

    public Evento insert(Evento e) {
        String ruta = imgUtils.saveImageBase64("eventos", e.getImagen());
        e.setImagen(ruta);
        return eventRepo.save(e);
    }

    public Evento update(Evento e, int id) {
        if(eventRepo.existsById(id)) {
            e.setId(id);
            return eventRepo.save(e);
        }
        return null; // No existe
    }

    public void delete(int id) {
        eventRepo.deleteById(id);
    }
}
