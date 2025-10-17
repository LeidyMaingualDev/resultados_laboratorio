package com.laboratorio.services.facturacion;

import com.laboratorio.entities.users.facturacion.FacPNivel;
import com.laboratorio.repositories.facturacion.FacPNivelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacPNivelService {

    private final FacPNivelRepository facPNivelRepository;

    // Listar todos los niveles
    public List<FacPNivel> listarTodos() {
        return facPNivelRepository.findAll();
    }

    // Obtener nivel por ID
    public Optional<FacPNivel> obtenerPorId(Long id) {
        return facPNivelRepository.findById(id);
    }

    // Crear o guardar nivel
    public FacPNivel guardar(FacPNivel nivel) {
        return facPNivelRepository.save(nivel);
    }

    // Actualizar nivel existente
    public FacPNivel actualizar(Long id, FacPNivel nivelActualizado) {
        return facPNivelRepository.findById(id)
                .map(nivel -> {
                    nivel.setEps(nivelActualizado.getEps());
                    nivel.setNivel(nivelActualizado.getNivel());
                    nivel.setNombre(nivelActualizado.getNombre());
                    nivel.setRegimen(nivelActualizado.getRegimen());
                    return facPNivelRepository.save(nivel);
                })
                .orElseThrow(() -> new RuntimeException("Nivel no encontrado con id: " + id));
    }

    // Eliminar nivel
    public void eliminar(Long id) {
        facPNivelRepository.deleteById(id);
    }
}
