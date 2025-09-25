package pe.edu.upeu.deliverymedicamentos.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "TBL_DETALLES_PEDIDO")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PEDIDO_ID", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "MEDICAMENTO_ID", nullable = false)
    private Medicamento medicamento;

    @Column(name = "CANTIDAD", nullable = false)
    private Integer cantidad;

    @Column(name = "SUBTOTAL", nullable = false)
    private Double subtotal;
}

