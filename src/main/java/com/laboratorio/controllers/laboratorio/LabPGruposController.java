package com.laboratorio.controllers.laboratorio;

import com.laboratorio.entities.users.laboratorio.LabPGrupos;
import com.laboratorio.services.laboratorio.LabPGruposService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
@RequiredArgsConstructor
public class LabPGruposController {

    private final LabPGruposService labPGruposService;

    // Listar todos los grupos
    @GetMapping
    public ResponseEntity<List<LabPGrupos>> listarTodos() {
        return ResponseEntity.ok(labPGruposService.listarTodos());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<LabPGrupos> obtenerPorId(@PathVariable Long id) {
        return labPGruposService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nuevo grupo
    @PostMapping
    public ResponseEntity<LabPGrupos> guardar(@RequestBody LabPGrupos grupos) {
        return ResponseEntity.ok(labPGruposService.guardar(grupos));
    }

    // Actualizar grupo existente
    @PutMapping("/{id}")
    public ResponseEntity<LabPGrupos> actualizar(@PathVariable Long id, @RequestBody LabPGrupos gruposActualizado) {
        return ResponseEntity.ok(labPGruposService.actualizar(id, gruposActualizado));
    }

    // Eliminar grupo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        labPGruposService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}