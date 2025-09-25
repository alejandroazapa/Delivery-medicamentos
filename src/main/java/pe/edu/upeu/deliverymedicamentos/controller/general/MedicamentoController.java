package pe.edu.upeu.deliverymedicamentos.controller.general;

import pe.edu.upeu.deliverymedicamentos.dto.MedicamentoDTO;
import pe.edu.upeu.deliverymedicamentos.service.service.MedicamentoService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicamentos")
public class MedicamentoController {

    private final MedicamentoService service;

    public MedicamentoController(MedicamentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoDTO> findById(@PathVariable Long id) throws ServiceException {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/barcode/{codigo}")
    public ResponseEntity<MedicamentoDTO> findByCodigoBarras(@PathVariable String codigo) {
        return ResponseEntity.ok(service.findByCodigoBarras(codigo));
    }

    @PostMapping
    public ResponseEntity<MedicamentoDTO> create(@RequestBody MedicamentoDTO dto) throws ServiceException {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicamentoDTO> update(@PathVariable Long id, @RequestBody MedicamentoDTO dto) throws ServiceException {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ServiceException {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

