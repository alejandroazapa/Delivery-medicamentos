package pe.edu.upeu.deliverymedicamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.deliverymedicamentos.entity.Ubicacion;
import java.util.List;

public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {
    List<Ubicacion> findByUsuarioId(Long usuarioId);
}
