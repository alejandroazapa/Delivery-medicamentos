package pe.edu.upeu.deliverymedicamentos.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String email;
    private String password;
    private String rol;
}

