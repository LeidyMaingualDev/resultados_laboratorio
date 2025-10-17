package com.laboratorio.controllers.general;

import com.laboratorio.entities.users.general.GenListaOpcion;
import com.laboratorio.services.general.GenListaOpcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/opciones")
@RequiredArgsConstructor
public class GenListaOpcionController {

    private final GenListaOpcionService genListaOpcionService;

    @GetMapping
    public ResponseEntity<List<GenListaOpcion>> listarTodas() {
        return ResponseEntity.ok(genListaOpcionService.listarTodos());
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<GenListaOpcion>> listarPorCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(genListaOpcionService.listarPorCategoria(categoria));
    }

    @PostMapping
    public ResponseEntity<GenListaOpcion> crearOpcion(@RequestBody GenListaOpcion opcion) {
        return ResponseEntity.ok(genListaOpcionService.guardar(opcion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        genListaOpcionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }


}
