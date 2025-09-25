package pe.edu.upeu.deliverymedicamentos.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "TBL_PEDIDOS")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FECHA", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "ESTADO", nullable = false, length = 20)
    private String estado; // PENDIENTE, EN_CAMINO, ENTREGADO

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", nullable = false)
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "REPARTIDOR_ID")
    private Usuario repartidor;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetallePedido> detalles;
}
