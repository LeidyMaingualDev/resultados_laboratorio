package com.laboratorio.services.facturacion;

import com.laboratorio.entities.users.facturacion.FacMTarjetero;
import com.laboratorio.repositories.facturacion.FacMTarjeteroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacMTarjeteroService {

    private final FacMTarjeteroRepository facMTarjeteroRepository;

    // Listar todos los registros
    public List<FacMTarjetero> listarTodos() {
        return facMTarjeteroRepository.findAll();
    }

    // Obtener un registro por ID
    public Optional<FacMTarjetero> obtenerPorId(Long id) {
        return facMTarjeteroRepository.findById(id);
    }

    // Guardar nuevo registro
    public FacMTarjetero guardar(FacMTarjetero tarjetero) {
        return facMTarjeteroRepository.save(tarjetero);
    }

    // Actualizar registro existente
    public FacMTarjetero actualizar(Long id, FacMTarjetero tarjeteroActualizado) {
        return facMTarjeteroRepository.findById(id)
                .map(tarjetero -> {
                    tarjetero.setHistoria(tarjeteroActualizado.getHistoria());
                    tarjetero.setPersona(tarjeteroActualizado.getPersona());
                    tarjetero.setRegimen(tarjeteroActualizado.getRegimen());
                    tarjetero.setEps(tarjeteroActualizado.getEps());
                    tarjetero.setNivel(tarjeteroActualizado.getNivel());
                    return facMTarjeteroRepository.save(tarjetero);
                })
                .orElseThrow(() -> new RuntimeException("Tarjetero no encontrado con id: " + id));
    }

    // Eliminar por ID
    public void eliminar(Long id) {
        facMTarjeteroRepository.deleteById(id);
    }
}
