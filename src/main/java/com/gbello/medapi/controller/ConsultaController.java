package com.gbello.medapi.controller;

import com.gbello.medapi.model.Consulta;
import com.gbello.medapi.service.ConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {
    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public Consulta createConsulta(@RequestBody Consulta consulta) {
        return consultaService.saveConsulta(consulta);
    }

    @GetMapping
    public List<Consulta> getAllConsultas() {
        return consultaService.getAllConsultas();
    }

    @GetMapping("/{id}")
    public Consulta getConsultaById(@PathVariable Long id) {
        return consultaService.getConsultaById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConsulta(@PathVariable Long id) {
        consultaService.deleteConsulta(id);
        return ResponseEntity.ok().build();
    }
}
