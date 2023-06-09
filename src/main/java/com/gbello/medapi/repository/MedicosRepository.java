package com.gbello.medapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gbello.medapi.model.Medico;
import java.util.List;

public interface MedicosRepository extends JpaRepository<Medico, Long> {
    List<Medico> findByAtivoTrue();
}
