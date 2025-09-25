package pe.edu.upeu.deliverymedicamentos.mappers;

import pe.edu.upeu.deliverymedicamentos.dto.UsuarioDTO;
import pe.edu.upeu.deliverymedicamentos.entity.Usuario;
import pe.edu.upeu.deliverymedicamentos.mappers.base.BaseMappers;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends BaseMappers<Usuario, UsuarioDTO> {
}

