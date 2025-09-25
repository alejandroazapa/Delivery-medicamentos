package pe.edu.upeu.deliverymedicamentos.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoDTO {
    private Long id;
    private LocalDateTime fecha;
    private String estado;
    private Long clienteId;
    private Long repartidorId;
    private List<DetallePedidoDTO> detalles;
}
