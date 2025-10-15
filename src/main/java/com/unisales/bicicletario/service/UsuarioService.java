package com.unisales.bicicletario.service;

import com.unisales.bicicletario.model.Usuario;
import com.unisales.bicicletario.model.TipoUsuario;
import com.unisales.bicicletario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Registra um novo usuário (usado para cadastro de Aluno).
     */
    @Transactional
    public Usuario registrarNovoUsuario(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            throw new RuntimeException("O e-mail " + usuario.getEmail() + " já está cadastrado.");
        }
        if (usuario.getTipoUsuario() == null) {
            usuario.setTipoUsuario(TipoUsuario.ALUNO);
        }
        // Simulação de Hashing: Apenas salva a senha
        return usuarioRepository.save(usuario);
    }

    /**
     * Autentica um usuário para login (fusão com AuthService).
     */
    public Usuario autenticar(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null || !usuario.getSenha().equals(senha)) {
            throw new RuntimeException("Credenciais inválidas.");
        }
        
        if (!usuario.getAtivo()) {
            throw new RuntimeException("Usuário inativo.");
        }

        return usuario;
    }
}
