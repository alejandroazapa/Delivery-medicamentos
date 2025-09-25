package pe.edu.upeu.deliverymedicamentos.service.impl;

import pe.edu.upeu.deliverymedicamentos.controller.exception.ResourceNotFoundException;
import pe.edu.upeu.deliverymedicamentos.dto.UsuarioDTO;
import pe.edu.upeu.deliverymedicamentos.entity.Usuario;
import pe.edu.upeu.deliverymedicamentos.mappers.UsuarioMapper;
import pe.edu.upeu.deliverymedicamentos.repository.UsuarioRepository;
import pe.edu.upeu.deliverymedicamentos.service.service.UsuarioService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repo;
    private final UsuarioMapper mapper;

    public UsuarioServiceImpl(UsuarioRepository repo, UsuarioMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public UsuarioDTO create(UsuarioDTO dto) throws ServiceException {
        return mapper.toDTO(repo.save(mapper.toEntity(dto)));
    }

    @Override
    public UsuarioDTO update(Long id, UsuarioDTO dto) throws ServiceException {
        Usuario usuario = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setRol(dto.getRol());
        return mapper.toDTO(repo.save(usuario));
    }

    @Override
    public UsuarioDTO findById(Long id) throws ServiceException {
        return mapper.toDTO(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado")));
    }

    @Override
    public void deleteById(Long id) throws ServiceException {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Usuario no encontrado");
        }
        repo.deleteById(id);
    }

    @Override
    public List<UsuarioDTO> findAll() throws ServiceException {
        return mapper.toDTOs(repo.findAll());
    }

    @Override
    public UsuarioDTO findByEmail(String email) {
        return repo.findByEmail(email)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con email: " + email));
    }
}
