package com.laboratorio.controllers.facturacion;

import com.laboratorio.entities.users.facturacion.FacMTarjetero;
import com.laboratorio.services.facturacion.FacMTarjeteroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarjeteros")
@RequiredArgsConstructor
public class FacMTarjeteroController {

    private final FacMTarjeteroService facMTarjeteroService;

    // Listar todos los registros
    @GetMapping
    public ResponseEntity<List<FacMTarjetero>> listarTodos() {
        return ResponseEntity.ok(facMTarjeteroService.listarTodos());
    }

    // Obtener registro por ID
    @GetMapping("/{id}")
    public ResponseEntity<FacMTarjetero> obtenerPorId(@PathVariable Long id) {
        return facMTarjeteroService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nuevo registro
    @PostMapping
    public ResponseEntity<FacMTarjetero> guardar(@RequestBody FacMTarjetero tarjetero) {
        return ResponseEntity.ok(facMTarjeteroService.guardar(tarjetero));
    }

    // Actualizar registro existente
    @PutMapping("/{id}")
    public ResponseEntity<FacMTarjetero> actualizar(@PathVariable Long id, @RequestBody FacMTarjetero tarjeteroActualizado) {
        return ResponseEntity.ok(facMTarjeteroService.actualizar(id, tarjeteroActualizado));
    }

    // Eliminar registro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        facMTarjeteroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
