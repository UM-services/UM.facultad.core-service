package um.facultad.rest.hexagonal.matriculacion.infrastructure.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.matriculacion.domain.model.Persona;
import um.facultad.rest.model.PersonaEntity;

@Component
public class PersonaMapper {

    public Persona toModel(PersonaEntity personaEntity) {
        if (personaEntity == null) {
            return null;
        }
        return Persona.builder()
                .personaId(personaEntity.getPersonaId())
                .documentoId(personaEntity.getDocumentoId())
                .apellido(personaEntity.getApellido())
                .nombre(personaEntity.getNombre())
                .build();
    }

}
