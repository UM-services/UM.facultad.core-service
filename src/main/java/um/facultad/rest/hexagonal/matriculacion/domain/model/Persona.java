package um.facultad.rest.hexagonal.matriculacion.domain.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    private BigDecimal personaId;
    private Integer documentoId;
    private String apellido;
    private String nombre;
    
}
