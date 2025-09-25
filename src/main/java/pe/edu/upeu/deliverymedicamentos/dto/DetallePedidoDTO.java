package pe.edu.upeu.deliverymedicamentos.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetallePedidoDTO {
    private Long id;
    private Long pedidoId;
    private Long medicamentoId;
    private Integer cantidad;
    private BigDecimal subtotal;
}

