package com.example.springeventos.usuarios;

import java.util.List;

import com.example.springeventos.usuarios.proyecciones.UsuarioConEventos;
import com.example.springeventos.usuarios.proyecciones.UsuarioSinEventos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
    List<UsuarioSinEventos> findBy();
    UsuarioConEventos findWithEventosById(Integer id);
    UsuarioSinEventos findWithoutEventosById(Integer id);

    @Query(value = "INSERT INTO usuario_asiste_evento VALUES (:usuario,:evento)", nativeQuery = true)
    void asistirEvento(int usuario, int evento);

    Usuario findByCorreoAndPassword(String correo, String password); 
}
