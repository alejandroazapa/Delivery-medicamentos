package pe.edu.upeu.deliverymedicamentos.service.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import pe.edu.upeu.deliverymedicamentos.controller.exception.ResourceNotFoundException;
import pe.edu.upeu.deliverymedicamentos.dto.PedidoDTO;
import pe.edu.upeu.deliverymedicamentos.entity.DetallePedido;
import pe.edu.upeu.deliverymedicamentos.entity.Medicamento;
import pe.edu.upeu.deliverymedicamentos.entity.Pedido;
import pe.edu.upeu.deliverymedicamentos.mappers.PedidoMapper;
import pe.edu.upeu.deliverymedicamentos.repository.DetallePedidoRepository;
import pe.edu.upeu.deliverymedicamentos.repository.MedicamentoRepository;
import pe.edu.upeu.deliverymedicamentos.repository.PedidoRepository;
import pe.edu.upeu.deliverymedicamentos.service.service.PedidoService;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepo;
    private final MedicamentoRepository medicamentoRepo;
    private final DetallePedidoRepository detalleRepo;
    private final PedidoMapper mapper;

    public PedidoServiceImpl(PedidoRepository pedidoRepo,
                             MedicamentoRepository medicamentoRepo,
                             DetallePedidoRepository detalleRepo,
                             PedidoMapper mapper) {
        this.pedidoRepo = pedidoRepo;
        this.medicamentoRepo = medicamentoRepo;
        this.detalleRepo = detalleRepo;
        this.mapper = mapper;
    }

    @Override
    public PedidoDTO create(PedidoDTO dto) throws ServiceException {
        Pedido pedido = mapper.toEntity(dto);
        BigDecimal total = BigDecimal.ZERO;

        for (DetallePedido detalle : pedido.getDetalles()) {
            Medicamento med = medicamentoRepo.findById(detalle.getMedicamento().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Medicamento no encontrado"));
            detalle.setPedido(pedido);
            detalle.setPrecioUnitario(med.getPrecio());
            detalle.setSubtotal(med.getPrecio().multiply(BigDecimal.valueOf(detalle.getCantidad())));
            total = total.add(detalle.getSubtotal());
        }

        pedido.setMontoTotal(total);
        pedido.setEstado("PENDIENTE");

        return mapper.toDTO(pedidoRepo.save(pedido));
    }

    @Override
    public PedidoDTO update(Long id, PedidoDTO dto) throws ServiceException {
        Pedido pedido = pedidoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
        pedido.setEstado(dto.getEstado());
        return mapper.toDTO(pedidoRepo.save(pedido));
    }

    @Override
    public PedidoDTO findById(Long id) throws ServiceException {
        return mapper.toDTO(pedidoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado")));
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
        return mapper.toDTOs(pedidoRepo.findAll());
    }
}
