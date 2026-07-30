package um.facultad.rest.hexagonal.carreras.carrera.infrastructure.web.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarreraResponse {

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

    private String planNombre;
}
