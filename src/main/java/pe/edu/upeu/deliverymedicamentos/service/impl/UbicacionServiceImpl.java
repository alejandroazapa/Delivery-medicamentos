package pe.edu.upeu.deliverymedicamentos.service.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import pe.edu.upeu.deliverymedicamentos.dto.UbicacionDTO;
import pe.edu.upeu.deliverymedicamentos.entity.Ubicacion;
import pe.edu.upeu.deliverymedicamentos.mappers.UbicacionMapper;
import pe.edu.upeu.deliverymedicamentos.repository.UbicacionRepository;
import pe.edu.upeu.deliverymedicamentos.repository.UsuarioRepository;
import pe.edu.upeu.deliverymedicamentos.service.service.UbicacionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UbicacionServiceImpl implements UbicacionService {

    private final UbicacionRepository ubicacionRepository;
    private final UsuarioRepository usuarioRepository;
    private final UbicacionMapper mapper;

    @Override
    public UbicacionDTO create(UbicacionDTO dto) {
        var usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ServiceException("Usuario no encontrado"));
        Ubicacion ubicacion = mapper.toEntity(dto);
        ubicacion.setUsuario(usuario);
        return mapper.toDTO(ubicacionRepository.save(ubicacion));
    }

    @Override
    public UbicacionDTO update(Long id, UbicacionDTO dto) {
        Ubicacion ubicacion = ubicacionRepository.findById(id)
                .orElseThrow(() -> new ServiceException("Ubicación no encontrada"));
        ubicacion.setNombre(dto.getNombre());
        ubicacion.setDireccion(dto.getDireccion());
        ubicacion.setCiudad(dto.getCiudad());
        ubicacion.setProvincia(dto.getProvincia());
        ubicacion.setCodigoPostal(dto.getCodigoPostal());
        ubicacion.setLatitud(dto.getLatitud());
        ubicacion.setLongitud(dto.getLongitud());
        ubicacion.setPrincipal(dto.getPrincipal());
        return mapper.toDTO(ubicacionRepository.save(ubicacion));
    }

    @Override
    public void delete(Long id) {
        ubicacionRepository.deleteById(id);
    }

    @Override
    public List<UbicacionDTO> findByUsuario(Long usuarioId) {
        return mapper.toDTOs(ubicacionRepository.findByUsuarioId(usuarioId));
    }
}
