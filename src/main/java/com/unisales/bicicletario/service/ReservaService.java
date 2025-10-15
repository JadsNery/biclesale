package com.unisales.bicicletario.service;

import com.unisales.bicicletario.model.*;
import com.unisales.bicicletario.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;
    
    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Cria uma reserva para o usuário, selecionando a primeira vaga livre.
     */
    @Transactional
    public Reserva criarReserva(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        if (reservaRepository.findByUsuarioIdAndStatus(usuarioId, StatusReserva.PENDENTE).isPresent()) {
            throw new RuntimeException("Você já possui uma reserva pendente.");
        }

        List<Vaga> vagasLivres = vagaRepository.findByStatus(StatusVaga.LIVRE);
        if (vagasLivres.isEmpty()) {
            throw new RuntimeException("Não há vagas livres disponíveis no momento.");
        }
        
        Vaga vagaSelecionada = vagasLivres.get(0);
        vagaSelecionada.setStatus(StatusVaga.RESERVADA);
        vagaRepository.save(vagaSelecionada);

        String qrCode = UUID.randomUUID().toString();
        Reserva novaReserva = new Reserva(usuario, vagaSelecionada, qrCode);
        novaReserva.setStatus(StatusReserva.PENDENTE);
        
        return reservaRepository.save(novaReserva);
    }
    
    /**
     * Simula a leitura do QR Code (Check-in), liberando o acesso.
     */
    @Transactional
    public Reserva liberarAcessoPorQrCode(String qrCodeData) {
        Reserva reserva = reservaRepository.findByQrCodeAcessoAndStatus(qrCodeData, StatusReserva.PENDENTE)
            .orElseThrow(() -> new RuntimeException("QR Code inválido ou reserva expirada/já utilizada."));

        reserva.setStatus(StatusReserva.CONCLUIDA);
        reserva.setDataHoraAcesso(LocalDateTime.now());
        reservaRepository.save(reserva);

        Vaga vaga = reserva.getVaga();
        vaga.setStatus(StatusVaga.OCUPADA);
        vagaRepository.save(vaga);
        
        return reserva;
    }
    
    /**
     * Retorna o resumo do status do bicicletário (fusão com VagaService).
     */
    public Map<String, Long> contarStatusVagas() {
        Map<String, Long> statusMap = new HashMap<>();
        statusMap.put("TOTAL", vagaRepository.count());
        statusMap.put("LIVRE", vagaRepository.countByStatus(StatusVaga.LIVRE));
        statusMap.put("RESERVADA", vagaRepository.countByStatus(StatusVaga.RESERVADA));
        statusMap.put("OCUPADA", vagaRepository.countByStatus(StatusVaga.OCUPADA));
        statusMap.put("MANUTENCAO", vagaRepository.countByStatus(StatusVaga.MANUTENCAO));
        return statusMap;
    }
}
