package pe.edu.upeu.deliverymedicamentos.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "TBL_USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "PASSWORD", nullable = false, length = 255)
    private String password;

    @Column(name = "ROL", nullable = false, length = 20)
    private String rol;  // Ejemplo: CLIENTE, REPARTIDOR, ADMIN
}

