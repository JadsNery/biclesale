package com.unisales.bicicletario.controller;

import com.unisales.bicicletario.model.Reserva;
import com.unisales.bicicletario.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    // Endpoint de CRIAÇÃO DE RESERVA: POST /api/reservas
    @PostMapping
    public ResponseEntity<?> criarReserva(@RequestBody Map<String, Long> request) {
        Long usuarioId = request.get("usuarioId");
        if (usuarioId == null) {
            return ResponseEntity.badRequest().body("O ID do usuário é obrigatório.");
        }
        
        try {
            Reserva novaReserva = reservaService.criarReserva(usuarioId);
            
            return ResponseEntity.ok(Map.of(
                "reservaId", novaReserva.getId(),
                "qrCodeData", novaReserva.getQrCodeAcesso(),
                "status", novaReserva.getStatus().toString()
            ));
            
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    // Endpoint de CHECK-IN (QR Code): POST /api/reservas/checkin
    @PostMapping("/checkin")
    public ResponseEntity<?> checkinQrCode(@RequestBody Map<String, String> request) {
        String qrCodeData = request.get("qrCodeData");
        
        if (qrCodeData == null || qrCodeData.isEmpty()) {
            return ResponseEntity.badRequest().body("Dados do QR Code são obrigatórios.");
        }
        
        try {
            Reserva reservaAtualizada = reservaService.liberarAcessoPorQrCode(qrCodeData);
            
            return ResponseEntity.ok(Map.of(
                "mensagem", "Acesso liberado com sucesso.",
                "vaga", reservaAtualizada.getVaga().getNumeroVaga(),
                "usuario", reservaAtualizada.getUsuario().getNome()
            ));
            
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
    
    // Endpoint de STATUS DE VAGAS: GET /api/reservas/vagas/status (Fusão com VagaController)
    @GetMapping("/vagas/status")
    public ResponseEntity<Map<String, Long>> getStatusVagas() {
        Map<String, Long> status = reservaService.contarStatusVagas();
        return ResponseEntity.ok(status);
    }
}
