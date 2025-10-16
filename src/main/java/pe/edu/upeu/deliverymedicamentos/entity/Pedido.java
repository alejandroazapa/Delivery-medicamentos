package pe.edu.upeu.deliverymedicamentos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TBL_PEDIDOS")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔗 Relación con usuario (luego conectaremos el login aquí)
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @Column(name = "FECHA_PEDIDO", nullable = false)
    private LocalDateTime fechaPedido = LocalDateTime.now();

    @Column(name = "MONTO_TOTAL", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoTotal;

    @Column(name = "ESTADO", nullable = false, length = 20)
    private String estado; // PENDIENTE, PAGADO, ENVIADO, ENTREGADO...

    // 🔗 Relación 1:N con detalle pedido
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detalles;
}

