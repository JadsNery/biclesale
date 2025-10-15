package com.unisales.bicicletario.repository;

import com.unisales.bicicletario.model.Reserva;
import com.unisales.bicicletario.model.StatusReserva; // CORRETO: Importa o Enum de seu próprio arquivo
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositório para a entidade Reserva.
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    /**
     * Verifica se o usuário já possui uma reserva PENDENTE.
     * Retorna um Optional para evitar exceções caso não encontre.
     */
    Optional<Reserva> findByUsuarioIdAndStatus(Long usuarioId, StatusReserva status);

    /**
     * Busca uma reserva pelo QR Code e pelo status (deve ser PENDENTE) para o check-in.
     */
    Optional<Reserva> findByQrCodeAcessoAndStatus(String qrCodeAcesso, StatusReserva status);
}
