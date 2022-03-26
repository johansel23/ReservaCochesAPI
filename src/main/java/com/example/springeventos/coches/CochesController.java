package com.example.springeventos.coches;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/coches")
public class CochesController {
    private final @NonNull CochesService cocheService;

    @GetMapping
    public List<Coche> findAll(){
        return cocheService.findAll();
    }
}
