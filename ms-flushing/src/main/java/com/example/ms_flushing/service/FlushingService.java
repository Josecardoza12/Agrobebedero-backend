package com.example.ms_flushing.service;

import com.example.ms_flushing.model.RegistroFlushing;
import com.example.ms_flushing.repository.FlushingRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class FlushingService {

    private final FlushingRepository repository;

    public FlushingService(FlushingRepository repository) {
        this.repository = repository;
    }

    public List<RegistroFlushing> listar() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public RegistroFlushing obtener(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Registro de flushing no encontrado: " + id));
    }

    public RegistroFlushing crear(RegistroFlushing registro) {
        validar(registro);
        registro.setId(null);
        return repository.save(registro);
    }

    public RegistroFlushing actualizar(Long id, RegistroFlushing datos) {
        RegistroFlushing existente = obtener(id);
        validar(datos);
        existente.setGranja(datos.getGranja());
        existente.setGalpon(datos.getGalpon());
        existente.setLinea(datos.getLinea());
        existente.setResponsable(datos.getResponsable());
        existente.setMotivo(datos.getMotivo());
        existente.setObservaciones(datos.getObservaciones());
        existente.setFecha(datos.getFecha());
        return repository.save(existente);
    }

    public void eliminar(Long id) {
        obtener(id);
        repository.deleteById(id);
    }

    private void validar(RegistroFlushing r) {
        if (vacio(r.getGranja()) || vacio(r.getGalpon()) || vacio(r.getLinea())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Granja, galpón y línea son obligatorios");
        }
        if (vacio(r.getResponsable()) || r.getResponsable().trim().length() < 3) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "El responsable debe tener al menos 3 caracteres");
        }
        if (vacio(r.getMotivo())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "El motivo es obligatorio");
        }
        if (vacio(r.getFecha())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "La fecha es obligatoria");
        }
    }

    private boolean vacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}