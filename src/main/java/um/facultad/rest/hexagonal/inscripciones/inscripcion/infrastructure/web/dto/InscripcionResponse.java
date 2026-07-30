package um.facultad.rest.hexagonal.inscripciones.inscripcion.infrastructure.web.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionResponse {

    private Integer facultadId;
    private BigDecimal personaId;
    private Integer documentoId;
    private Integer lectivoId;
    private Long inscripcionId;
    private OffsetDateTime fecha;
    private String chequera;
    private String matricula;
    private Long factura;
    private Integer curso;
    private Integer planId;
    private Integer carreraId;
    private Integer geograficaId;
    private Byte asentado;
    private Byte provisoria;
    private Integer cohorte;
    private Byte remota;
    private Byte imprimir;
    private Integer edad;
    private String observaciones;
    private Integer offsetpago;
    private Integer libre;
    private Integer divisionId;
    private Byte debematricula;

}
