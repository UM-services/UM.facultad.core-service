package um.facultad.rest.hexagonal.carreras.plan.infrastructure.web.dto;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanResponse {

    private Long uniqueId;
    private Integer facultadId;
    private Integer planId;
    private String nombre;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXX", timezone = "UTC")
    private OffsetDateTime fecha;

    @Builder.Default
    private Byte publicar = 0;

    @Builder.Default
    private Integer semanas = 0;

}
