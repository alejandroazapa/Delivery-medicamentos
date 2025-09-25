package pe.edu.upeu.deliverymedicamentos.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MedicamentoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private String codigoBarras;
    private BigDecimal precio;
    private Integer stock;
}

