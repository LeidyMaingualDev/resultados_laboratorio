package com.laboratorio.services.general;

import com.laboratorio.entities.users.general.GenPersona;
import com.laboratorio.repositories.general.GenPersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenPersonaService {

    private final GenPersonaRepository repository;

    //listar todas las personas
    public List<GenPersona> findAll() {
        return repository.findAll();
    }

    //buscar por id
    public Optional<GenPersona> findById(Long id) {
        return repository.findById(id);
    }

    //crear o actualizar persona
    public GenPersona save(GenPersona persona) {
        return repository.save(persona);
    }

    //eliminar persona por id
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
