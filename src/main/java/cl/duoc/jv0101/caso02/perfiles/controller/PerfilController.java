package cl.duoc.jv0101.caso02.perfiles.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.duoc.jv0101.caso02.perfiles.model.Perfil;
import cl.duoc.jv0101.caso02.perfiles.service.PerfilService;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilController {

    private final PerfilService service;

    public PerfilController(PerfilService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Perfil>> listar() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perfil> obtener(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Perfil> crear(@Valid @RequestBody Perfil recurso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(recurso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perfil> actualizar(@PathVariable Long id,
            @Valid @RequestBody Perfil datos) {
        return service.update(id, datos).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
