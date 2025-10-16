package pe.edu.upeu.deliverymedicamentos.service.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import pe.edu.upeu.deliverymedicamentos.controller.exception.ResourceNotFoundException;
import pe.edu.upeu.deliverymedicamentos.dto.CategoriaDTO;
import pe.edu.upeu.deliverymedicamentos.entity.Categoria;
import pe.edu.upeu.deliverymedicamentos.mappers.CategoriaMapper;
import pe.edu.upeu.deliverymedicamentos.repository.CategoriaRepository;
import pe.edu.upeu.deliverymedicamentos.service.service.CategoriaService;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository repo;
    private final CategoriaMapper mapper;

    public CategoriaServiceImpl(CategoriaRepository repo, CategoriaMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public CategoriaDTO create(CategoriaDTO dto) throws ServiceException {
        return mapper.toDTO(repo.save(mapper.toEntity(dto)));
    }

    @Override
    public CategoriaDTO update(Long id, CategoriaDTO dto) throws ServiceException {
        Categoria categoria = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada"));
        categoria.setNombre(dto.getNombre());
        categoria.setDescripcion(dto.getDescripcion());
        return mapper.toDTO(repo.save(categoria));
    }

    @Override
    public CategoriaDTO findById(Long id) throws ServiceException {
        return mapper.toDTO(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada")));
    }

    @Override
    public void deleteById(Long id) throws ServiceException {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Categoría no encontrada");
        }
        repo.deleteById(id);
    }

    @Override
    public List<CategoriaDTO> findAll() throws ServiceException {
        return mapper.toDTOs(repo.findAll());
    }
}
