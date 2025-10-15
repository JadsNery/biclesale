package com.unisales.bicicletario.repository;

import com.unisales.bicicletario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório para a entidade Usuario.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Encontra um usuário pelo seu email. Essencial para o login e verificação de cadastro duplicado.
     * O Spring Data JPA cria a query automaticamente com base no nome do método.
     */
    Usuario findByEmail(String email);
}
