package com.laboratorio.services.general;

import com.laboratorio.entities.users.general.GenListaOpcion;
import com.laboratorio.repositories.general.GenListaOpcionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenListaOpcionService {

    private final GenListaOpcionRepository genListaOpcionRepository;

    public List<GenListaOpcion> listarTodos() {
        return genListaOpcionRepository.findAll();
    }

    public List<GenListaOpcion> listarPorCategoria(String categoria) {
        return genListaOpcionRepository.findByCategoria(categoria);
    }

    public Optional<GenListaOpcion> obtenerPorId(Long id) {
        return genListaOpcionRepository.findById(id);
    }

    public GenListaOpcion guardar(GenListaOpcion opcion) {
        return genListaOpcionRepository.save(opcion);
    }

    public void eliminar(Long id) {
        genListaOpcionRepository.deleteById(id);
    }
}
