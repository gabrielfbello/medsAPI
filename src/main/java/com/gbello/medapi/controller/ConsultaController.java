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
    public ResponseEntity<Consulta> createConsulta(@RequestBody Consulta consulta) {
        if (consulta == null) {
            throw new IllegalArgumentException("Consulta não pode ser nula");
        }
        Consulta savedConsulta = consultaService.saveConsulta(consulta);
        return ResponseEntity.ok(savedConsulta);
    }

    @GetMapping
    public List<Consulta> getAllConsultas() {
        return consultaService.getAllConsultas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getConsultaById(@PathVariable Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id não pode ser nulo");
        }
        Consulta consulta = consultaService.getConsultaById(id);
        return ResponseEntity.ok(consulta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConsulta(@PathVariable Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id não pode ser nulo");
        }
        consultaService.deleteConsulta(id);
        return ResponseEntity.ok().build();
    }
}
