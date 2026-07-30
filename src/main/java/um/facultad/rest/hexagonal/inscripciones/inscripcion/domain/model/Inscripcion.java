package um.facultad.rest.hexagonal.inscripciones.inscripcion.domain.model;

import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inscripcion {

    private Integer facultadId;
    private BigDecimal personaId;
    private Integer documentoId;
    private Integer lectivoId;

    private Long inscripcionId;

    private OffsetDateTime fecha;

    @Builder.Default
    private String chequera = "";

    @Builder.Default
    private String matricula = "";

    @Builder.Default
    private Long factura = 0L;

    @Builder.Default
    private Integer curso = 0;

    private Integer planId;
    private Integer carreraId;
    private Integer geograficaId;

    @Builder.Default
    private Byte asentado = 0;

    @Builder.Default
    private Byte provisoria = 0;

    @Builder.Default
    private Integer cohorte = 0;

    @Builder.Default
    private Byte remota = 0;

    @Builder.Default
    private Byte imprimir = 0;

    @Builder.Default
    private Integer edad = 0;

    @Builder.Default
    private String observaciones = "";

    @Builder.Default
    private Integer offsetpago = 0;

    @Builder.Default
    private Integer libre = 0;

    private Integer divisionId;

    @Builder.Default
    private Byte debematricula = 0;

    public String getKey() {
        return this.personaId + "." + this.documentoId;
    }

}
