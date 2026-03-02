package um.facultad.rest.hexagonal.matriculacion.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Plan {

    private Integer planId;
    private String nombre;

}
