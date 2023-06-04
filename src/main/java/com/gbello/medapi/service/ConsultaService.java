package com.gbello.medapi.service;

import com.gbello.medapi.exception.ResourceNotFoundException;
import com.gbello.medapi.model.Consulta;
import com.gbello.medapi.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {
    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    public Consulta saveConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    public Consulta getConsultaById(Long id) {
        return consultaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Consulta", "id", id));
    }

    public void deleteConsulta(Long id) {
        Consulta consulta = getConsultaById(id);
        consultaRepository.delete(consulta);
    }
}
