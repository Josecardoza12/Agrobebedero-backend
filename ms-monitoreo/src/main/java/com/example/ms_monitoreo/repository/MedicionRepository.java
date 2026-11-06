package com.example.ms_monitoreo.repository;

import com.example.ms_monitoreo.model.Medicion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicionRepository extends JpaRepository<Medicion, Long> {

    // Histórico de una línea (más reciente primero)
    List<Medicion> findByLineaIdOrderByFechaHoraDesc(Long lineaId);

    // Mediciones cuyo estado NO es el indicado (se usa con "Normal" para las alertas)
    List<Medicion> findByEstadoNotOrderByFechaHoraDesc(String estado);
}