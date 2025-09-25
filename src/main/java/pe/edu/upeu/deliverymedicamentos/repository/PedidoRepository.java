package pe.edu.upeu.deliverymedicamentos.repository;

import pe.edu.upeu.deliverymedicamentos.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
