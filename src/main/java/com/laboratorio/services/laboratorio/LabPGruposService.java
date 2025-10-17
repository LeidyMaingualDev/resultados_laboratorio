package com.laboratorio.services.laboratorio;

import com.laboratorio.entities.users.facturacion.FacPCups;
import com.laboratorio.entities.users.laboratorio.LabPGrupos;
import com.laboratorio.repositories.laboratorio.LabPGruposRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LabPGruposService {

    private final LabPGruposRepository labPGruposRepository;

    public List<LabPGrupos> listarTodos() {
        return labPGruposRepository.findAll();
    }

    public Optional<LabPGrupos> obtenerPorId(Long id) {
        return labPGruposRepository.findById(id);
    }

    public LabPGrupos guardar(LabPGrupos grupos) {
        return labPGruposRepository.save(grupos);
    }

    public LabPGrupos actualizar(Long id, LabPGrupos gruposActualizado) {
        return labPGruposRepository.findById(id)
                .map(grupos -> {
                    grupos.setCodigo(gruposActualizado.getCodigo());
                    grupos.setNombre(gruposActualizado.getNombre());
                    grupos.setHabilita(gruposActualizado.getHabilita());
                    return labPGruposRepository.save(grupos);
                })
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        labPGruposRepository.deleteById(id);
    }
}
