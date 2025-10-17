package com.laboratorio.controllers.general;

import com.laboratorio.entities.users.general.GenPDocumento;
import com.laboratorio.services.general.GenPDocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
@RequiredArgsConstructor
public class GenPDocumentoController {

    private final GenPDocumentoService genPDocumentoService;

    // Listar todos los documentos
    @GetMapping
    public ResponseEntity<List<GenPDocumento>> listarTodos() {
        return ResponseEntity.ok(genPDocumentoService.listarTodos());
    }

    // Obtener documento por ID
    @GetMapping("/{id}")
    public ResponseEntity<GenPDocumento> obtenerPorId(@PathVariable Long id) {
        return genPDocumentoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo documento
    @PostMapping
    public ResponseEntity<GenPDocumento> guardar(@RequestBody GenPDocumento documento) {
        return ResponseEntity.ok(genPDocumentoService.guardar(documento));
    }

    // Actualizar un documento existente
    @PutMapping("/{id}")
    public ResponseEntity<GenPDocumento> actualizar(@PathVariable Long id, @RequestBody GenPDocumento documentoActualizado) {
        return ResponseEntity.ok(genPDocumentoService.actualizar(id, documentoActualizado));
    }

    // Eliminar un documento por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        genPDocumentoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
