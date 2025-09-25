package pe.edu.upeu.deliverymedicamentos.service.impl;

import pe.edu.upeu.deliverymedicamentos.controller.exception.ResourceNotFoundException;
import pe.edu.upeu.deliverymedicamentos.dto.DetallePedidoDTO;
import pe.edu.upeu.deliverymedicamentos.dto.PedidoDTO;
import pe.edu.upeu.deliverymedicamentos.entity.DetallePedido;
import pe.edu.upeu.deliverymedicamentos.entity.Medicamento;
import pe.edu.upeu.deliverymedicamentos.entity.Pedido;
import pe.edu.upeu.deliverymedicamentos.entity.Usuario;
import pe.edu.upeu.deliverymedicamentos.repository.DetallePedidoRepository;
import pe.edu.upeu.deliverymedicamentos.repository.MedicamentoRepository;
import pe.edu.upeu.deliverymedicamentos.repository.PedidoRepository;
import pe.edu.upeu.deliverymedicamentos.repository.UsuarioRepository;
import pe.edu.upeu.deliverymedicamentos.service.service.PedidoService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepo;
    private final UsuarioRepository usuarioRepo;
    private final MedicamentoRepository medicamentoRepo;
    private final DetallePedidoRepository detalleRepo;

    public PedidoServiceImpl(PedidoRepository pedidoRepo,
                             UsuarioRepository usuarioRepo,
                             MedicamentoRepository medicamentoRepo,
                             DetallePedidoRepository detalleRepo) {
        this.pedidoRepo = pedidoRepo;
        this.usuarioRepo = usuarioRepo;
        this.medicamentoRepo = medicamentoRepo;
        this.detalleRepo = detalleRepo;
    }

    @Override
    public PedidoDTO create(PedidoDTO dto) throws ServiceException {
        // Buscar cliente
        Usuario cliente = usuarioRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        // Buscar repartidor (puede ser null si no asignado aún)
        Usuario repartidor = null;
        if (dto.getRepartidorId() != null) {
            repartidor = usuarioRepo.findById(dto.getRepartidorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Repartidor no encontrado"));
        }

        // Crear Pedido
        Pedido pedido = Pedido.builder()
                .fecha(dto.getFecha() != null ? dto.getFecha() : LocalDateTime.now())
                .estado(dto.getEstado() != null ? dto.getEstado() : "PENDIENTE")
                .cliente(cliente)
                .repartidor(repartidor)
                .build();

        pedido = pedidoRepo.save(pedido);

        // Crear Detalles
        List<DetallePedido> detalles = new ArrayList<>();
        if (dto.getDetalles() != null) {
            for (DetallePedidoDTO detDTO : dto.getDetalles()) {
                Medicamento medicamento = medicamentoRepo.findById(detDTO.getMedicamentoId())
                        .orElseThrow(() -> new ResourceNotFoundException("Medicamento no encontrado"));

                DetallePedido detalle = DetallePedido.builder()
                        .pedido(pedido)
                        .medicamento(medicamento)
                        .cantidad(detDTO.getCantidad())
                        .subtotal(detDTO.getSubtotal())
                        .build();

                detalles.add(detalleRepo.save(detalle));
            }
        }

        pedido.setDetalles(detalles);
        pedidoRepo.save(pedido);

        // Armar PedidoDTO de respuesta
        dto.setId(pedido.getId());
        dto.setFecha(pedido.getFecha());
        dto.setEstado(pedido.getEstado());

        return dto;
    }

    @Override
    public PedidoDTO update(Long id, PedidoDTO dto) throws ServiceException {
        Pedido pedido = pedidoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));

        pedido.setEstado(dto.getEstado() != null ? dto.getEstado() : pedido.getEstado());
        pedidoRepo.save(pedido);

        dto.setId(pedido.getId());
        dto.setFecha(pedido.getFecha());
        return dto;
    }

    @Override
    public PedidoDTO findById(Long id) throws ServiceException {
        Pedido pedido = pedidoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));

        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setFecha(pedido.getFecha());
        dto.setEstado(pedido.getEstado());
        dto.setClienteId(pedido.getCliente().getId());
        dto.setRepartidorId(pedido.getRepartidor() != null ? pedido.getRepartidor().getId() : null);

        return dto;
    }

    @Override
    public void deleteById(Long id) throws ServiceException {
        if (!pedidoRepo.existsById(id)) {
            throw new ResourceNotFoundException("Pedido no encontrado");
        }
        pedidoRepo.deleteById(id);
    }

    @Override
    public List<PedidoDTO> findAll() throws ServiceException {
        List<Pedido> pedidos = pedidoRepo.findAll();
        List<PedidoDTO> lista = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            PedidoDTO dto = new PedidoDTO();
            dto.setId(pedido.getId());
            dto.setFecha(pedido.getFecha());
            dto.setEstado(pedido.getEstado());
            dto.setClienteId(pedido.getCliente().getId());
            dto.setRepartidorId(pedido.getRepartidor() != null ? pedido.getRepartidor().getId() : null);
            lista.add(dto);
        }
        return lista;
    }
}

