package pe.edu.upeu.deliverymedicamentos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.edu.upeu.deliverymedicamentos.dto.DetallePedidoDTO;
import pe.edu.upeu.deliverymedicamentos.entity.DetallePedido;
import pe.edu.upeu.deliverymedicamentos.mappers.base.BaseMappers;

@Mapper(componentModel = "spring")
public interface DetallePedidoMapper extends BaseMappers<DetallePedido, DetallePedidoDTO> {

    @Override
    @Mapping(source = "medicamento.id", target = "medicamentoId")
    @Mapping(source = "medicamento.nombre", target = "medicamentoNombre")
    DetallePedidoDTO toDTO(DetallePedido entity);

    @Override
    @Mapping(source = "medicamentoId", target = "medicamento.id")
    DetallePedido toEntity(DetallePedidoDTO dto);
}


