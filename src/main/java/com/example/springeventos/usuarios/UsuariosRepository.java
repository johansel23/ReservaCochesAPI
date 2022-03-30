package com.example.springeventos.usuarios;

import java.util.List;

import com.example.springeventos.usuarios.proyecciones.UsuarioSinEventos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
    List<UsuarioSinEventos> findBy();

    Usuario findByCorreoAndPassword(String correo, String password); 
}
