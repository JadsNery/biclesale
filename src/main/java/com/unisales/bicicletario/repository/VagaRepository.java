package com.unisales.bicicletario.repository;

import com.unisales.bicicletario.model.Vaga;
import com.unisales.bicicletario.model.StatusVaga; // CORRETO: Importa o Enum de seu próprio arquivo
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para a entidade Vaga.
 */
@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {

    /**
     * Encontra todas as vagas que possuem um determinado Status.
     * Usado principalmente para encontrar vagas LIVRES.
     */
    List<Vaga> findByStatus(StatusVaga status);

    /**
     * Conta o número de vagas com um determinado Status.
     * Essencial para o dashboard do Vigilante.
     */
    long countByStatus(StatusVaga status);
}
