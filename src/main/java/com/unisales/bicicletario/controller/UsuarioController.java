package com.unisales.bicicletario.controller;

import com.unisales.bicicletario.model.Usuario;
import com.unisales.bicicletario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Endpoint de CADASTRO: POST /api/usuarios/registrar
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarNovoUsuario(@RequestBody Usuario novoUsuario) {
        try {
            Usuario usuarioSalvo = usuarioService.registrarNovoUsuario(novoUsuario);
            usuarioSalvo.setSenha(null); 
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Endpoint de LOGIN: POST /api/usuarios/login (Fusão com AuthController)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String senha = request.get("senha");

        if (email == null || senha == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email e senha são obrigatórios.");
        }

        try {
            Usuario usuarioAutenticado = usuarioService.autenticar(email, senha);

            // Retorna dados essenciais para manter o estado do usuário na sessão/frontend
            return ResponseEntity.ok(Map.of(
                "id", usuarioAutenticado.getId(),
                "nome", usuarioAutenticado.getNome(),
                "email", usuarioAutenticado.getEmail(),
                "tipoUsuario", usuarioAutenticado.getTipoUsuario().toString()
            ));

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
