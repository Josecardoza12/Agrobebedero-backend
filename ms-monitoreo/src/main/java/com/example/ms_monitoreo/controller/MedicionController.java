package com.example.ms_monitoreo.controller;

import com.example.ms_monitoreo.model.Medicion;
import com.example.ms_monitoreo.service.MedicionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mediciones")
@RequiredArgsConstructor
@Tag(name = "Mediciones", description = "Temperaturas del agua por línea de bebederos")
public class MedicionController {

    private final MedicionService service;

    @GetMapping
    @Operation(summary = "Listar todas las mediciones")
    public List<Medicion> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una medición por id")
    public Medicion obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @GetMapping("/linea/{lineaId}")
    @Operation(summary = "Histórico de temperaturas de una línea")
    public List<Medicion> historico(@PathVariable Long lineaId) {
        return service.historico(lineaId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Registrar medición (el estado se calcula automáticamente)")
    public Medicion crear(@RequestBody Medicion medicion) {
        return service.crear(medicion);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar medición")
    public Medicion actualizar(@PathVariable Long id, @RequestBody Medicion medicion) {
        return service.actualizar(id, medicion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Eliminar medición")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}