package com.example.ms_instalaciones.controller;

import com.example.ms_instalaciones.model.LineaBebedero;
import com.example.ms_instalaciones.service.LineaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lineas")
@Tag(name = "Líneas de bebederos", description = "CRUD de granjas, galpones y líneas")
public class LineaController {

    private final LineaService service;

    public LineaController(LineaService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Listar líneas (filtro opcional por granja y galpón)")
    public List<LineaBebedero> listar(@RequestParam(required = false) String granja,
                                      @RequestParam(required = false) String galpon) {
        return service.listar(granja, galpon);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una línea por id")
    public LineaBebedero obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @GetMapping("/granjas")
    @Operation(summary = "Listar granjas (para selector)")
    public List<String> granjas() {
        return service.granjas();
    }

    @GetMapping("/galpones")
    @Operation(summary = "Listar galpones de una granja (para selector)")
    public List<String> galpones(@RequestParam String granja) {
        return service.galpones(granja);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Crear línea")
    public LineaBebedero crear(@RequestBody LineaBebedero linea) {
        return service.crear(linea);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar línea")
    public LineaBebedero actualizar(@PathVariable Long id, @RequestBody LineaBebedero linea) {
        return service.actualizar(id, linea);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Eliminar línea")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}