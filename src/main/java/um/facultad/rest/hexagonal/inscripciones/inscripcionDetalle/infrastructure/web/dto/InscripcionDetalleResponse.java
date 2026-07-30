package um.facultad.rest.hexagonal.inscripciones.inscripcionDetalle.infrastructure.web.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import um.facultad.rest.hexagonal.carreras.materia.infrastructure.web.dto.MateriaResponse;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionDetalleResponse {

    private BigDecimal personaId;
    private Integer documentoId;
    private Integer lectivoId;
    private Integer facultadId;
    private Integer planId;
    private String materiaId;
    private Long inscripciondetalleId;
    @Builder.Default
    private Integer cursoId = 0;
    @Builder.Default
    private Integer periodoId = 0;
    private Integer divisionId;
    @Builder.Default
    private Byte recursa = 0;
    @Builder.Default
    private Byte imprimir = 0;
    @Builder.Default
    private Byte moroso = 0;
    @Builder.Default
    private Byte libre = 0;
    @Builder.Default
    private Byte condicional = 0;

    private MateriaResponse materia;

}
