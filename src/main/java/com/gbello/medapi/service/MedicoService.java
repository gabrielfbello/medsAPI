package com.gbello.medapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbello.medapi.model.Medico;
import com.gbello.medapi.repository.MedicoRepository;
import com.gbello.medapi.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    @Autowired
    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> getAllMedicos() {
        return medicoRepository.findAll();
    }

    public Medico createMedico(Medico medico) {
        return medicoRepository.save(medico);
    }

    public Medico updateMedico(Long id, Medico medicoDetails) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medico", "id", id));
        medico.setNome(medicoDetails.getNome());
        medico.setTelefone(medicoDetails.getTelefone());
        medico.setEndereco(medicoDetails.getEndereco());
        return medicoRepository.save(medico);
    }

    public void deleteMedico(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medico", "id", id));
        medico.setAtivo(false);
        medicoRepository.save(medico);
    }
}