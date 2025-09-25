package pe.edu.upeu.deliverymedicamentos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "TBL_MEDICAMENTOS")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "CODIGO_BARRAS", unique = true, nullable = false)
    private String codigoBarras;

    @Column(name = "PRECIO", nullable = false)
    private BigDecimal precio;

    @Column(name = "STOCK", nullable = false)
    private Integer stock;

}
