package com.emanuel.vet.sistema.dtos;

import java.time.LocalDateTime;

public record ScheduleDTO(Long vetId, Long petId, LocalDateTime agendamento) {
}
