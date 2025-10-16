package pe.edu.upeu.deliverymedicamentos.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_UBICACIONES")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 255)
    private String direccion;

    private String ciudad;
    private String provincia;
    private String codigoPostal;
    private String latitud;
    private String longitud;

    @Column(length = 1)
    private String principal; // 'S' o 'N'
}
