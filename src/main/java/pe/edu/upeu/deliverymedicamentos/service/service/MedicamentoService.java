package pe.edu.upeu.deliverymedicamentos.service.service;

import pe.edu.upeu.deliverymedicamentos.dto.MedicamentoDTO;
import pe.edu.upeu.deliverymedicamentos.entity.Medicamento;
import pe.edu.upeu.deliverymedicamentos.service.base.GenericService;

public interface MedicamentoService extends GenericService<Medicamento, MedicamentoDTO, Long> {
    MedicamentoDTO findByCodigoBarras(String codigoBarras);
}

