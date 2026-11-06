package com.example.ms_instalaciones.service;

import com.example.ms_instalaciones.model.LineaBebedero;
import com.example.ms_instalaciones.repository.LineaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LineaService {

    private final LineaRepository repo;

    public LineaService(LineaRepository repo) {
        this.repo = repo;
    }

    public List<LineaBebedero> listar(String granja, String galpon) {
        if (granja != null && galpon != null) {
            return repo.findByGranjaAndGalponOrderByLineaAsc(granja, galpon);
        }
        if (granja != null) {
            return repo.findByGranjaOrderByGalponAscLineaAsc(granja);
        }
        return repo.findAllByOrderByGranjaAscGalponAscLineaAsc();
    }

    public LineaBebedero obtener(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Línea no encontrada"));
    }

    public List<String> granjas() {
        return repo.listarGranjas();
    }

    public List<String> galpones(String granja) {
        return repo.listarGalpones(granja);
    }

    public LineaBebedero crear(LineaBebedero linea) {
        validar(linea);
        linea.setId(null);
        return repo.save(linea);
    }

    public LineaBebedero actualizar(Long id, LineaBebedero datos) {
        LineaBebedero actual = obtener(id);
        validar(datos);
        actual.setGranja(datos.getGranja());
        actual.setGalpon(datos.getGalpon());
        actual.setLinea(datos.getLinea());
        return repo.save(actual);
    }

    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Línea no encontrada");
        }
        repo.deleteById(id);
    }

    private void validar(LineaBebedero l) {
        if (esVacio(l.getGranja()) || esVacio(l.getGalpon()) || esVacio(l.getLinea())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Completa granja, galpón y línea");
        }
    }

    private boolean esVacio(String texto) {
        return texto == null || texto.isBlank();
    }
}