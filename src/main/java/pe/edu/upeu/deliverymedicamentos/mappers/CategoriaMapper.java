package pe.edu.upeu.deliverymedicamentos.mappers;

import org.mapstruct.Mapper;
import pe.edu.upeu.deliverymedicamentos.dto.CategoriaDTO;
import pe.edu.upeu.deliverymedicamentos.entity.Categoria;
import pe.edu.upeu.deliverymedicamentos.mappers.base.BaseMappers;

@Mapper(componentModel = "spring")
public interface CategoriaMapper extends BaseMappers<Categoria, CategoriaDTO> {
}
