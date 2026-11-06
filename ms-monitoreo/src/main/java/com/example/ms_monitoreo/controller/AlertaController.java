package com.example.ms_monitoreo.controller;

import com.example.ms_monitoreo.model.Alerta;
import com.example.ms_monitoreo.service.AlertaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
@RequiredArgsConstructor
@Tag(name = "Alertas", description = "Mediciones en estado Advertencia o Crítico")
public class AlertaController {

    private final AlertaService service;

    @GetMapping
    @Operation(summary = "Listar alertas (filtro opcional: Advertencia o Crítico)")
    public List<Alerta> listar(@RequestParam(required = false) String nivel) {
        return service.listar(nivel);
    }
}