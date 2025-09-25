package pe.edu.upeu.deliverymedicamentos.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetallePedidoDTO {
    private Long id;
    private Long pedidoId;
    private Long medicamentoId;
    private Integer cantidad;
    private Double subtotal;
}

