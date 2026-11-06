package com.example.ms_monitoreo.service;

import com.example.ms_monitoreo.model.Medicion;
import com.example.ms_monitoreo.repository.MedicionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicionService {

    private final MedicionRepository repo;

    public List<Medicion> listar() {
        return repo.findAll();
    }

    public List<Medicion> historico(Long lineaId) {
        return repo.findByLineaIdOrderByFechaHoraDesc(lineaId);
    }

    public Medicion obtener(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medición no encontrada"));
    }

    public Medicion crear(Medicion m) {
        validar(m);
        m.setId(null);
        m.setEstado(calcularEstado(m.getTemperatura()));
        if (m.getFechaHora() == null) {
            m.setFechaHora(LocalDateTime.now());
        }
        return repo.save(m);
    }

    public Medicion actualizar(Long id, Medicion datos) {
        Medicion actual = obtener(id);
        validar(datos);
        actual.setLineaId(datos.getLineaId());
        actual.setTemperatura(datos.getTemperatura());
        actual.setEstado(calcularEstado(datos.getTemperatura()));
        if (datos.getFechaHora() != null) {
            actual.setFechaHora(datos.getFechaHora());
        }
        return repo.save(actual);
    }

    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Medición no encontrada");
        }
        repo.deleteById(id);
    }

    // Regla de negocio: único lugar donde se decide el estado
    public String calcularEstado(Double temperatura) {
        if (temperatura >= 30) return "Crítico";
        if (temperatura >= 27) return "Advertencia";
        return "Normal";
    }

    private void validar(Medicion m) {
        if (m.getLineaId() == null || m.getLineaId() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "lineaId inválido");
        }
        if (m.getTemperatura() == null || m.getTemperatura() < 0 || m.getTemperatura() > 100) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La temperatura debe estar entre 0 y 100");
        }
    }
}