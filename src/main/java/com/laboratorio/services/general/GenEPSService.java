package com.laboratorio.services.general;

import com.laboratorio.entities.users.general.GenEPS;
import com.laboratorio.repositories.general.GenEPSRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenEPSService {

    private final GenEPSRepository genEPSRepository;

    public List<GenEPS> listarTodos() {
        return genEPSRepository.findAll();
    }

    public Optional<GenEPS> obtenerPorId(Long id) {
        return genEPSRepository.findById(id);
    }

    public GenEPS guardar(GenEPS eps) {
        return genEPSRepository.save(eps);
    }

    public GenEPS actualizar(Long id, GenEPS epsActualizada) {
        return genEPSRepository.findById(id)
                .map(eps -> {
                    eps.setCodigo(epsActualizada.getCodigo());
                    eps.setRazonSocial(epsActualizada.getRazonSocial());
                    eps.setNit(epsActualizada.getNit());
                    eps.setHabilita(epsActualizada.getHabilita());
                    return genEPSRepository.save(eps);
                })
                .orElseThrow(() -> new RuntimeException("EPS no encontrada con id: " + id));
    }

    public void eliminar(Long id) {
        genEPSRepository.deleteById(id);
    }
}
