package com.laboratorio.services.facturacion;

import com.laboratorio.entities.users.facturacion.FacPCups;
import com.laboratorio.repositories.facturacion.FacPCupsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacPCupsService {

    private final FacPCupsRepository facPCupsRepository;

    public List<FacPCups> listarTodos() {
        return facPCupsRepository.findAll();
    }

    public Optional<FacPCups> obtenerPorId(Long id) {
        return facPCupsRepository.findById(id);
    }

    public FacPCups guardar(FacPCups cups) {
        return facPCupsRepository.save(cups);
    }

    public FacPCups actualizar(Long id, FacPCups cupsActualizado) {
        return facPCupsRepository.findById(id)
                .map(cups -> {
                    cups.setCodigo(cupsActualizado.getCodigo());
                    cups.setNombre(cupsActualizado.getNombre());
                    cups.setHabilita(cupsActualizado.getHabilita());
                    return facPCupsRepository.save(cups);
                })
                .orElseThrow(() -> new RuntimeException("CUPS no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        facPCupsRepository.deleteById(id);
    }
}
