package com.example.ms_monitoreo.model;

import java.time.LocalDateTime;

// No es entidad: se genera a partir de las mediciones en Advertencia o Crítico
public record Alerta(
        Long medicionId,
        Long lineaId,
        String nivel,
        Double temperatura,
        String mensaje,
        LocalDateTime fechaHora
) {
}