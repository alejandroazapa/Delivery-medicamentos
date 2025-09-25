package pe.edu.upeu.deliverymedicamentos.controller.general;

import pe.edu.upeu.deliverymedicamentos.dto.PedidoDTO;
import pe.edu.upeu.deliverymedicamentos.service.service.PedidoService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable Long id) throws ServiceException {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> create(@RequestBody PedidoDTO dto) throws ServiceException {
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> update(@PathVariable Long id, @RequestBody PedidoDTO dto) throws ServiceException {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ServiceException {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

