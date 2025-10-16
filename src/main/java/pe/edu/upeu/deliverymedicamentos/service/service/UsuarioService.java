package pe.edu.upeu.deliverymedicamentos.service.service;

import pe.edu.upeu.deliverymedicamentos.dto.UsuarioDTO;
import org.hibernate.service.spi.ServiceException;
import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> findAll() throws ServiceException;
    UsuarioDTO findById(Long id) throws ServiceException;
    UsuarioDTO findByEmail(String email) throws ServiceException;
    UsuarioDTO create(UsuarioDTO dto) throws ServiceException;
    UsuarioDTO update(Long id, UsuarioDTO dto) throws ServiceException;
    void deleteById(Long id) throws ServiceException;
}
