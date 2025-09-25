package pe.edu.upeu.deliverymedicamentos.mappers;

import pe.edu.upeu.deliverymedicamentos.dto.MedicamentoDTO;
import pe.edu.upeu.deliverymedicamentos.entity.Medicamento;
import pe.edu.upeu.deliverymedicamentos.mappers.base.BaseMappers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicamentoMapper extends BaseMappers<Medicamento, MedicamentoDTO> {
}

