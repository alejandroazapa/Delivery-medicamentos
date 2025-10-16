package pe.edu.upeu.deliverymedicamentos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    private Long id;
    private Long usuarioId;
    private LocalDateTime fechaPedido;
    private BigDecimal montoTotal;
    private String estado;
    private List<DetallePedidoDTO> detalles;
}
