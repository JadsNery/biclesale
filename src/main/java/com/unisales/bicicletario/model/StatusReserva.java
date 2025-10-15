package com.unisales.bicicletario.model;

/**
 * Enumeração que define o estado do ciclo de vida da Reserva.
 * (Corrigido para ser um arquivo de nível superior)
 */
public enum StatusReserva {
    /** Reserva criada, aguardando check-in. */
    PENDENTE, 
    
    /** Reserva utilizada (check-in feito). */
    CONCLUIDA, 
    
    /** Reserva cancelada pelo usuário. */
    CANCELADA, 
    
    /** Reserva não utilizada e o prazo expirou. */
    EXPIRADA
}
