package com.unisales.bicicletario.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Representa o Bean (Entidade) Reserva.
 * Mapeada para a tabela 'RESERVA' no banco de dados.
 */
@Entity
@Table(name = "RESERVA")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento: N Reservas para 1 Usuário
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Relacionamento: N Reservas para 1 Vaga
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vaga_id", nullable = false)
    private Vaga vaga;

    /** Data e hora em que a reserva foi solicitada. */
    @Column(name = "data_hora_reserva", nullable = false)
    private LocalDateTime dataHoraReserva = LocalDateTime.now();

    /**
     * Status da reserva, usando o Enum StatusReserva.java.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusReserva status = StatusReserva.PENDENTE; // Usa o Enum StatusReserva

    /** Código único que será transformado em QR Code para liberação de acesso. */
    @Column(name = "qr_code_acesso", unique = true)
    private String qrCodeAcesso;

    /** Momento em que a reserva foi liberada pelo QR Code (check-in). */
    @Column(name = "data_hora_acesso")
    private LocalDateTime dataHoraAcesso;

    // Construtor padrão (obrigatório para JPA)
    public Reserva() {}

    // Construtor essencial para criar uma nova reserva
    public Reserva(Usuario usuario, Vaga vaga, String qrCodeAcesso) {
        this.usuario = usuario;
        this.vaga = vaga;
        this.qrCodeAcesso = qrCodeAcesso;
        this.dataHoraReserva = LocalDateTime.now();
        this.status = StatusReserva.PENDENTE;
    }

    // ========================================================================
    // GETTERS E SETTERS
    // ========================================================================
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Vaga getVaga() { return vaga; }
    public void setVaga(Vaga vaga) { this.vaga = vaga; }
    public LocalDateTime getDataHoraReserva() { return dataHoraReserva; }
    public void setDataHoraReserva(LocalDateTime dataHoraReserva) { this.dataHoraReserva = dataHoraReserva; }
    public StatusReserva getStatus() { return status; }
    public void setStatus(StatusReserva status) { this.status = status; }
    public String getQrCodeAcesso() { return qrCodeAcesso; }
    public void setQrCodeAcesso(String qrCodeAcesso) { this.qrCodeAcesso = qrCodeAcesso; }
    public LocalDateTime getDataHoraAcesso() { return dataHoraAcesso; }
    public void setDataHoraAcesso(LocalDateTime dataHoraAcesso) { this.dataHoraAcesso = dataHoraAcesso; }
}
