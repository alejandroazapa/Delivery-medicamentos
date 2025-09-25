package pe.edu.upeu.deliverymedicamentos.service.impl;

import pe.edu.upeu.deliverymedicamentos.controller.exception.ResourceNotFoundException;
import pe.edu.upeu.deliverymedicamentos.dto.MedicamentoDTO;
import pe.edu.upeu.deliverymedicamentos.entity.Medicamento;
import pe.edu.upeu.deliverymedicamentos.mappers.MedicamentoMapper;
import pe.edu.upeu.deliverymedicamentos.repository.MedicamentoRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;
import pe.edu.upeu.deliverymedicamentos.service.service.MedicamentoService;

import java.util.List;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {

    private final MedicamentoRepository repo;
    private final MedicamentoMapper mapper;

    public MedicamentoServiceImpl(MedicamentoRepository repo, MedicamentoMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public MedicamentoDTO create(MedicamentoDTO dto) throws ServiceException {
        return mapper.toDTO(repo.save(mapper.toEntity(dto)));
    }

    @Override
    public MedicamentoDTO update(Long id, MedicamentoDTO dto) throws ServiceException {
        Medicamento medicamento = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicamento no encontrado"));
        medicamento.setNombre(dto.getNombre());
        medicamento.setDescripcion(dto.getDescripcion());
        medicamento.setCodigoBarras(dto.getCodigoBarras());
        medicamento.setPrecio(dto.getPrecio());
        medicamento.setStock(dto.getStock());
        return mapper.toDTO(repo.save(medicamento));
    }

    @Override
    public MedicamentoDTO findById(Long id) throws ServiceException {
        return mapper.toDTO(repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicamento no encontrado")));
    }

    @Override
    public void deleteById(Long id) throws ServiceException {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Medicamento no encontrado");
        }
        repo.deleteById(id);
    }

    @Override
    public List<MedicamentoDTO> findAll() throws ServiceException {
        return mapper.toDTOs(repo.findAll());
    }

    @Override
    public MedicamentoDTO findByCodigoBarras(String codigoBarras) {
        return repo.findByCodigoBarras(codigoBarras)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Medicamento no encontrado por código de barras"));
    }
}

