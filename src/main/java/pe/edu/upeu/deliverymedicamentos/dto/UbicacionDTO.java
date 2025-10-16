package pe.edu.upeu.deliverymedicamentos.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UbicacionDTO {
    private Long id;
    private Long usuarioId;
    private String nombre;
    private String direccion;
    private String ciudad;
    private String provincia;
    private String codigoPostal;
    private String latitud;
    private String longitud;
    private String principal;
}
