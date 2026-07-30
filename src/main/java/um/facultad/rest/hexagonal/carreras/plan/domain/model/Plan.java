package um.facultad.rest.hexagonal.carreras.plan.domain.model;

import java.time.OffsetDateTime;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Plan {

    private Long uniqueId;
    private Integer facultadId;
    private Integer planId;
    private String nombre;
    private OffsetDateTime fecha;
    @Builder.Default
    private Byte publicar = 0;
    @Builder.Default
    private Integer semanas = 0;

}
