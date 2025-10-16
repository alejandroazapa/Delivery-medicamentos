package pe.edu.upeu.deliverymedicamentos.controller.general;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.deliverymedicamentos.dto.MedicamentoDTO;
import pe.edu.upeu.deliverymedicamentos.service.service.MedicamentoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicamentos")
@RequiredArgsConstructor
public class MedicamentoController {

    private final MedicamentoService service;

    @GetMapping
    public ResponseEntity<List<MedicamentoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/barcode/{codigo}")
    public ResponseEntity<MedicamentoDTO> findByCodigoBarras(@PathVariable String codigo) {
        return ResponseEntity.ok(service.findByCodigoBarras(codigo));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<MedicamentoDTO> create(@RequestBody MedicamentoDTO dto) {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<MedicamentoDTO> update(@PathVariable Long id, @RequestBody MedicamentoDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


