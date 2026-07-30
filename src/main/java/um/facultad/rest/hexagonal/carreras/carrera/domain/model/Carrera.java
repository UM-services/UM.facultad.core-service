package um.facultad.rest.hexagonal.carreras.carrera.domain.model;

import lombok.*;
import um.facultad.rest.hexagonal.carreras.plan.domain.model.Plan;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Carrera {

    private Plan plan;
    private Integer facultadId;
    private Integer planId;
    private Integer carreraId;
    private String nombre;

    @Builder.Default
    private String iniciales = "";

    @Builder.Default
    private String titulo = "";

    @Builder.Default
    private Byte trabajoFinal = 0;

    @Builder.Default
    private String resolucion = "";

    @Builder.Default
    private Byte chequeraUnica = 0;

    private Integer bloqueId;

    @Builder.Default
    private Integer obligatorias = 0;

    @Builder.Default
    private Integer optativas = 0;

    @Builder.Default
    private Byte vigente = 0;

    public String getKey() {
        return this.facultadId + "." + this.planId + "." + this.carreraId;
    }

}
