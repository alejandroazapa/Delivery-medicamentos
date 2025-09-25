package pe.edu.upeu.deliverymedicamentos.controller.general;

import pe.edu.upeu.deliverymedicamentos.dto.UsuarioDTO;
import pe.edu.upeu.deliverymedicamentos.service.service.UsuarioService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id) throws ServiceException {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioDTO> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.findByEmail(email));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO dto) throws ServiceException {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody UsuarioDTO dto) throws ServiceException {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ServiceException {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
