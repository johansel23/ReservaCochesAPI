package com.example.springeventos.usuarios;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsuariosService {
    private final @NonNull UsuariosRepository usuRepo;
    

    public List<Usuario> findAll() {
        return usuRepo.findAll();
    }

    public Usuario insert(Usuario u) throws NoSuchAlgorithmException {
        u.setPassword(encodePassword(u.getPassword()));
        return usuRepo.save(u);
    }

    public Usuario login(String correo, String password) throws NoSuchAlgorithmException {
        return usuRepo.findByCorreoAndPassword(correo, encodePassword(password));
    }

    public Usuario update(Usuario e, int id) {
        if(usuRepo.existsById(id)) {
            e.setId(id);
            return usuRepo.save(e);
        }
        return null; // No existe
    }


    private String encodePassword(String pass) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
		String encodedPass = Base64.getEncoder().encodeToString(hash);
		return encodedPass;
	}
}
