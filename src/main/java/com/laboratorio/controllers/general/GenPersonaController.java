package com.laboratorio.controllers.general;

import com.laboratorio.entities.users.general.GenPersona;
import com.laboratorio.services.general.GenPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
@RequiredArgsConstructor
public class GenPersonaController {

    private final GenPersonaService service;

    // Listar todas las personas
    @GetMapping
    public ResponseEntity<List<GenPersona>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    // Buscar persona por ID
    @GetMapping("/{id}")
    public ResponseEntity<GenPersona> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear nueva persona
    @PostMapping
    public ResponseEntity<GenPersona> create(@RequestBody GenPersona persona) {
        return ResponseEntity.ok(service.save(persona));
    }

    // Actualizar persona existente
    @PutMapping("/{id}")
    public ResponseEntity<GenPersona> update(@PathVariable Long id, @RequestBody GenPersona persona) {
        return service.findById(id)
                .map(existing -> {
                    persona.setId(id);
                    return ResponseEntity.ok(service.save(persona));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar persona por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
