package pe.edu.upeu.deliverymedicamentos.mappers;

import org.mapstruct.Mapper;
import pe.edu.upeu.deliverymedicamentos.dto.PedidoDTO;
import pe.edu.upeu.deliverymedicamentos.entity.Pedido;
import pe.edu.upeu.deliverymedicamentos.mappers.base.BaseMappers;

@Mapper(componentModel = "spring", uses = {DetallePedidoMapper.class})
public interface PedidoMapper extends BaseMappers<Pedido, PedidoDTO> {
}
