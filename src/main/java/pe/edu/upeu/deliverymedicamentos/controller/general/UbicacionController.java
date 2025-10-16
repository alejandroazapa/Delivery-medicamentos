package pe.edu.upeu.deliverymedicamentos.controller.general;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.deliverymedicamentos.dto.UbicacionDTO;
import pe.edu.upeu.deliverymedicamentos.entity.Usuario;
import pe.edu.upeu.deliverymedicamentos.service.service.UbicacionService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ubicaciones")
@RequiredArgsConstructor
public class UbicacionController {

    private final UbicacionService service;

    @PostMapping
    public ResponseEntity<UbicacionDTO> create(@RequestBody UbicacionDTO dto) {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        dto.setUsuarioId(usuario.getId());
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UbicacionDTO> update(@PathVariable Long id, @RequestBody UbicacionDTO dto) {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        dto.setUsuarioId(usuario.getId());
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UbicacionDTO>> findByUsuario() {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(service.findByUsuario(usuario.getId()));
    }
}

