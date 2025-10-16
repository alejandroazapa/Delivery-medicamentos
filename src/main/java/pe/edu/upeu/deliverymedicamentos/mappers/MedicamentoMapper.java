package pe.edu.upeu.deliverymedicamentos.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.edu.upeu.deliverymedicamentos.dto.MedicamentoDTO;
import pe.edu.upeu.deliverymedicamentos.entity.Medicamento;
import pe.edu.upeu.deliverymedicamentos.mappers.base.BaseMappers;

@Mapper(componentModel = "spring")
public interface MedicamentoMapper extends BaseMappers<Medicamento, MedicamentoDTO> {

    @Override
    @Mapping(source = "categoria.id", target = "categoriaId")
    @Mapping(source = "categoria.nombre", target = "categoriaNombre")
    MedicamentoDTO toDTO(Medicamento entity);

    @Override
    @Mapping(source = "categoriaId", target = "categoria.id")
    Medicamento toEntity(MedicamentoDTO dto);
}

