package com.example.springeventos.auth;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.example.springeventos.auth.dto.LoginDto;
import com.example.springeventos.auth.dto.TokenResponseDto;
import com.example.springeventos.seguridad.SecurityConstants;
import com.example.springeventos.usuarios.Usuario;
import com.example.springeventos.usuarios.UsuariosService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final @NonNull UsuariosService usuService;

    @GetMapping("/getCurrentUser")
    public int currentUserId(Authentication authentication){
        var userId = authentication.getCredentials();
        return (int) userId;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody @Valid LoginDto login) throws NoSuchAlgorithmException {
        Usuario u = usuService.login(login.getCorreo(), login.getPassword());
        if(u != null) {
            String token = getToken(u);
            TokenResponseDto resp = new TokenResponseDto(token);
            return ResponseEntity.ok().body(resp);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/registro")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void registro(@RequestBody @Valid Usuario usuario) throws NoSuchAlgorithmException {
        usuService.insert(usuario);
    }

    @GetMapping("/validate")
    public void validateToken() {
        // No hace nada, solo sirve para que el token se valide
    }

    private String getToken(Usuario user) {	
		Map<String, Object> data = new HashMap<String, Object>();
		
		data.put("id", user.getId());
		data.put("correo", user.getCorreo());
		data.put("authorities", Arrays.asList("ROLE_USER"));
		
		String token = Jwts.builder().setId("springEventos")
				.setSubject(user.getNombre()).addClaims(data)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + (24*60*60*1000))) // Caduca en un día
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET_KEY).compact();
		
		return token;
	}
}
