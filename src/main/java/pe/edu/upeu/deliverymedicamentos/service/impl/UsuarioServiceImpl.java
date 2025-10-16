package pe.edu.upeu.deliverymedicamentos.service.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import pe.edu.upeu.deliverymedicamentos.dto.UsuarioDTO;
import pe.edu.upeu.deliverymedicamentos.entity.Usuario;
import pe.edu.upeu.deliverymedicamentos.mappers.UsuarioMapper;
import pe.edu.upeu.deliverymedicamentos.repository.UsuarioRepository;
import pe.edu.upeu.deliverymedicamentos.service.service.UsuarioService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    @Override
    public List<UsuarioDTO> findAll() {
        return mapper.toDTOs(repository.findAll());
    }

    @Override
    public UsuarioDTO findById(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ServiceException("Usuario no encontrado"));
        return mapper.toDTO(usuario);
    }

    @Override
    public UsuarioDTO findByEmail(String email) {
        Usuario usuario = repository.findByEmail(email)
                .orElseThrow(() -> new ServiceException("Usuario no encontrado"));
        return mapper.toDTO(usuario);
    }

    @Override
    public UsuarioDTO create(UsuarioDTO dto) {
        Usuario usuario = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(usuario));
    }

    @Override
    public UsuarioDTO update(Long id, UsuarioDTO dto) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new ServiceException("Usuario no encontrado"));
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setRol(dto.getRol());
        return mapper.toDTO(repository.save(usuario));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

