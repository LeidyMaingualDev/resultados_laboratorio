package com.laboratorio.services.general;

import com.laboratorio.entities.users.general.GenPDocumento;
import com.laboratorio.repositories.general.GenPDocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class GenPDocumentoService {

    private final GenPDocumentoRepository genPDocumentoRepository;

    // Listar todos los documentos
    public List<GenPDocumento> listarTodos() {
        return genPDocumentoRepository.findAll();
    }

    // Obtener documento por ID
    public Optional<GenPDocumento> obtenerPorId(Long id) {
        return genPDocumentoRepository.findById(id);
    }

    // Crear un nuevo documento
    public GenPDocumento guardar(GenPDocumento documento) {
        return genPDocumentoRepository.save(documento);
    }

    // Actualizar un documento existente
    public GenPDocumento actualizar(Long id, GenPDocumento documentoActualizado) {
        return genPDocumentoRepository.findById(id)
                .map(documento -> {
                    documento.setCodigo(documentoActualizado.getCodigo());
                    documento.setNombre(documentoActualizado.getNombre());
                    documento.setHabilita(documentoActualizado.getHabilita());
                    return genPDocumentoRepository.save(documento);
                })
                .orElseThrow(() -> new RuntimeException("Documento no encontrado con id: " + id));
    }

    // Eliminar documento por ID
    public void eliminar(Long id) {
        genPDocumentoRepository.deleteById(id);
    }
}
