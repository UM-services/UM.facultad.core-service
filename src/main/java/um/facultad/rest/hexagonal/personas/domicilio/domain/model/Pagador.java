package um.facultad.rest.hexagonal.personas.domicilio.domain.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pagador {

    private BigDecimal personaId;
    private Integer documentoId;

}
