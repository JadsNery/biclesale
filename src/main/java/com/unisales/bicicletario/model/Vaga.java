package com.unisales.bicicletario.model;

import jakarta.persistence.*;

/**
 * Representa o Bean (Entidade) Vaga.
 * Mapeada para a tabela 'VAGA' no banco de dados.
 */
@Entity
@Table(name = "VAGA")
public class Vaga {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Identificador único da vaga (ex: A01, B15). */
    @Column(name = "numero_vaga", nullable = false, unique = true)
    private String numeroVaga;

    /**
     * Status atual da vaga, usando o Enum StatusVaga.java.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusVaga status = StatusVaga.LIVRE; // Usa o Enum StatusVaga

    // Construtor padrão (obrigatório para JPA)
    public Vaga() {}

    // Construtor útil para inicializar vagas
    public Vaga(String numeroVaga, StatusVaga status) {
        this.numeroVaga = numeroVaga;
        this.status = status;
    }

    // ========================================================================
    // GETTERS E SETTERS
    // ========================================================================

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNumeroVaga() { return numeroVaga; }
    public void setNumeroVaga(String numeroVaga) { this.numeroVaga = numeroVaga; }
    public StatusVaga getStatus() { return status; }
    public void setStatus(StatusVaga status) { this.status = status; }
}
