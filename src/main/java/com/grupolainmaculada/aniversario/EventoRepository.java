package com.grupolainmaculada.aniversario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    public Optional<Evento> findByNumeroDocumento(String numeroDocumento);
    public List<Evento> findByApellidosContaining(String valor);
}
