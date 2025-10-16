package pe.edu.upeu.deliverymedicamentos.mappers;

import org.mapstruct.*;
import pe.edu.upeu.deliverymedicamentos.dto.UbicacionDTO;
import pe.edu.upeu.deliverymedicamentos.entity.Ubicacion;
import pe.edu.upeu.deliverymedicamentos.mappers.base.BaseMappers;

@Mapper(componentModel = "spring")
public interface UbicacionMapper extends BaseMappers<Ubicacion, UbicacionDTO> {
}
