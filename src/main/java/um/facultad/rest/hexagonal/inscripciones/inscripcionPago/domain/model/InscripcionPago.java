package um.facultad.rest.hexagonal.inscripciones.inscripcionPago.domain.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionPago {

    private Long inscripcionPagoId;
    private BigDecimal personaId;
    private Integer documentoId;
    private Integer facultadId;
    private Integer lectivoId;
    private BigDecimal personaIdPagador;
    private Integer documentoIdPagador;

}
