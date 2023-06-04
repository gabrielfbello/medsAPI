package com.gbello.medapi.service;

import com.gbello.medapi.exception.ResourceNotFoundException;
import com.gbello.medapi.model.Paciente;
import com.gbello.medapi.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente getPacienteById(Long id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Paciente", "id", id));
    }

    public void deletePaciente(Long id) {
        Paciente paciente = getPacienteById(id);
        pacienteRepository.delete(paciente);
    }
}
