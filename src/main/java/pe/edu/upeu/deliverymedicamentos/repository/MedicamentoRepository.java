package pe.edu.upeu.deliverymedicamentos.repository;

import pe.edu.upeu.deliverymedicamentos.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    Optional<Medicamento> findByCodigoBarras(String codigoBarras);
}

