package pe.edu.upeu.deliverymedicamentos.service.service;

import pe.edu.upeu.deliverymedicamentos.dto.UsuarioDTO;
import pe.edu.upeu.deliverymedicamentos.entity.Usuario;
import pe.edu.upeu.deliverymedicamentos.service.base.GenericService;

public interface UsuarioService extends GenericService<Usuario, UsuarioDTO, Long> {
    UsuarioDTO findByEmail(String email);
}

