package pe.edu.upeu.deliverymedicamentos.service.service;

import pe.edu.upeu.deliverymedicamentos.dto.UbicacionDTO;
import org.hibernate.service.spi.ServiceException;
import java.util.List;

public interface UbicacionService {
    UbicacionDTO create(UbicacionDTO dto) throws ServiceException;
    UbicacionDTO update(Long id, UbicacionDTO dto) throws ServiceException;
    void delete(Long id) throws ServiceException;
    List<UbicacionDTO> findByUsuario(Long usuarioId) throws ServiceException;
}
