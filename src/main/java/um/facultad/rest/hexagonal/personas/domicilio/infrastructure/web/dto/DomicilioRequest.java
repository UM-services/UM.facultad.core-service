package um.facultad.rest.hexagonal.personas.domicilio.infrastructure.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DomicilioRequest {

    @NotNull
    private BigDecimal personaId;

    @NotNull
    private Integer documentoId;

    private Long domicilioId;

    @Builder.Default
    private OffsetDateTime fecha = OffsetDateTime.now();

    @Builder.Default
    private String calle = "";

    @Builder.Default
    private String puerta = "";

    @Builder.Default
    private String piso = "";

    @Builder.Default
    private String dpto = "";

    @Builder.Default
    private String telefono = "";

    @Builder.Default
    private String movil = "";

    @Builder.Default
    private String observaciones = "";

    @Builder.Default
    private String codigoPostal = "";

    private Integer facultadId;
    private Integer provinciaId;
    private Integer localidadId;

    @Builder.Default
    private String emailPersonal = "";

    @Builder.Default
    private String emailInstitucional = "";

    @Builder.Default
    private String laboral = "";

}
