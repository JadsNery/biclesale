package com.unisales.bicicletario.model;

import jakarta.persistence.*;

/**
 * Representa o Bean (Entidade) Usuário.
 * Mapeada para a tabela 'USUARIO' no banco de dados.
 */
@Entity
@Table(name = "USUARIO")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 255) // Em produção, a senha seria hashed
    private String senha;

    /** Define o papel do usuário no sistema. */
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private TipoUsuario tipoUsuario;

    @Column(name = "is_ativo", nullable = false)
    private Boolean ativo = true;

    // Construtor padrão (obrigatório para JPA)
    public Usuario() {}

    // Construtor completo
    public Usuario(String nome, String email, String senha, TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    // ========================================================================
    // GETTERS E SETTERS
    // ========================================================================

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public TipoUsuario getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(TipoUsuario tipoUsuario) { this.tipoUsuario = tipoUsuario; }
    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}
