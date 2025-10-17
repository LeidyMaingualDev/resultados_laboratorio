package com.laboratorio.controllers.laboratorio;

import com.laboratorio.entities.users.facturacion.FacPNivel;
import com.laboratorio.services.facturacion.FacPNivelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/niveles")
@RequiredArgsConstructor
public class FacPNivelController {

    private final FacPNivelService facPNivelService;

    // Listar todos los niveles
    @GetMapping
    public ResponseEntity<List<FacPNivel>> listarTodos() {
        return ResponseEntity.ok(facPNivelService.listarTodos());
    }

    // Obtener nivel por ID
    @GetMapping("/{id}")
    public ResponseEntity<FacPNivel> obtenerPorId(@PathVariable Long id) {
        return facPNivelService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nuevo nivel
    @PostMapping
    public ResponseEntity<FacPNivel> guardar(@RequestBody FacPNivel nivel) {
        return ResponseEntity.ok(facPNivelService.guardar(nivel));
    }

    // Actualizar un nivel existente
    @PutMapping("/{id}")
    public ResponseEntity<FacPNivel> actualizar(@PathVariable Long id, @RequestBody FacPNivel nivelActualizado) {
        return ResponseEntity.ok(facPNivelService.actualizar(id, nivelActualizado));
    }

    // Eliminar nivel por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        facPNivelService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
