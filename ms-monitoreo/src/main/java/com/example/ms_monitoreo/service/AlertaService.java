package com.example.ms_monitoreo.service;

import com.example.ms_monitoreo.model.Alerta;
import com.example.ms_monitoreo.repository.MedicionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertaService {

    private final MedicionRepository repo;

    public AlertaService(MedicionRepository repo) {
        this.repo = repo;
    }

    public List<Alerta> listar(String nivel) {
        return repo.findByEstadoNotOrderByFechaHoraDesc("Normal").stream()
                .filter(m -> nivel == null || m.getEstado().equalsIgnoreCase(nivel))
                .map(m -> new Alerta(
                        m.getId(),
                        m.getLineaId(),
                        m.getEstado(),
                        m.getTemperatura(),
                        "Línea " + m.getLineaId() + " en estado " + m.getEstado()
                                + " (" + m.getTemperatura() + " °C)",
                        m.getFechaHora()
                ))
                .toList();
    }
}