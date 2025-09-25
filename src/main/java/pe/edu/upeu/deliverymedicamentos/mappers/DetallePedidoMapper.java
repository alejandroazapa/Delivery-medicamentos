package pe.edu.upeu.deliverymedicamentos.mappers;

import pe.edu.upeu.deliverymedicamentos.dto.DetallePedidoDTO;
import pe.edu.upeu.deliverymedicamentos.entity.DetallePedido;
import pe.edu.upeu.deliverymedicamentos.mappers.base.BaseMappers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetallePedidoMapper extends BaseMappers<DetallePedido, DetallePedidoDTO> {
}

