package pe.edu.upeu.deliverymedicamentos.mappers;

import pe.edu.upeu.deliverymedicamentos.dto.PedidoDTO;
import pe.edu.upeu.deliverymedicamentos.entity.Pedido;
import pe.edu.upeu.deliverymedicamentos.mappers.base.BaseMappers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper extends BaseMappers<Pedido, PedidoDTO> {
}

