package com.example.ms_flushing.controller;

import com.example.ms_flushing.model.RegistroFlushing;
import com.example.ms_flushing.service.FlushingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flushing")
public class FlushingController {

    private final FlushingService service;

    public FlushingController(FlushingService service) {
        this.service = service;
    }

    @GetMapping
    public List<RegistroFlushing> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public RegistroFlushing obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RegistroFlushing crear(@RequestBody RegistroFlushing registro) {
        return service.crear(registro);
    }

    @PutMapping("/{id}")
    public RegistroFlushing actualizar(@PathVariable Long id, @RequestBody RegistroFlushing registro) {
        return service.actualizar(id, registro);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
