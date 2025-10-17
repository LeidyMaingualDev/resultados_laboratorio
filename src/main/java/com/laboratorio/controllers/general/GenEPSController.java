package com.laboratorio.controllers.general;

import com.laboratorio.entities.users.general.GenEPS;
import com.laboratorio.services.general.GenEPSService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eps")
@RequiredArgsConstructor
public class GenEPSController {

    private final GenEPSService genEPSService;

    // Listar todas las EPS
    @GetMapping
    public ResponseEntity<List<GenEPS>> listarTodos() {
        return ResponseEntity.ok(genEPSService.listarTodos());
    }

    // Obtener EPS por ID
    @GetMapping("/{id}")
    public ResponseEntity<GenEPS> obtenerPorId(@PathVariable Long id) {
        return genEPSService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva EPS
    @PostMapping
    public ResponseEntity<GenEPS> crear(@RequestBody GenEPS eps) {
        return ResponseEntity.ok(genEPSService.guardar(eps));
    }

    // Actualizar una EPS existente
    @PutMapping("/{id}")
    public ResponseEntity<GenEPS> actualizar(@PathVariable Long id, @RequestBody GenEPS epsActualizada) {
        return ResponseEntity.ok(genEPSService.actualizar(id, epsActualizada));
    }

    // Eliminar una EPS
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        genEPSService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
