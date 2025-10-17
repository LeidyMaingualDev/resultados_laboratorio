package com.laboratorio.controllers.facturacion;

import com.laboratorio.entities.users.facturacion.FacPCups;
import com.laboratorio.services.facturacion.FacPCupsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cups")
@RequiredArgsConstructor
public class FacPCupsController {

    private final FacPCupsService facPCupsService;

    // Listar todos
    @GetMapping
    public ResponseEntity<List<FacPCups>> listarTodos() {
        return ResponseEntity.ok(facPCupsService.listarTodos());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<FacPCups> obtenerPorId(@PathVariable Long id) {
        return facPCupsService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nuevo CUPS
    @PostMapping
    public ResponseEntity<FacPCups> guardar(@RequestBody FacPCups cups) {
        return ResponseEntity.ok(facPCupsService.guardar(cups));
    }

    // Actualizar CUPS existente
    @PutMapping("/{id}")
    public ResponseEntity<FacPCups> actualizar(@PathVariable Long id, @RequestBody FacPCups cupsActualizado) {
        return ResponseEntity.ok(facPCupsService.actualizar(id, cupsActualizado));
    }

    // Eliminar CUPS
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        facPCupsService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
