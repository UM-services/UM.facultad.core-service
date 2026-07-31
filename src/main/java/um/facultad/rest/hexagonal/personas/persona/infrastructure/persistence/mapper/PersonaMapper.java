package um.facultad.rest.hexagonal.personas.persona.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.personas.persona.domain.model.Persona;
import um.facultad.rest.hexagonal.personas.persona.infrastructure.persistence.entity.PersonaEntity;

@Component("personasPersonaMapper")
public class PersonaMapper {

    public PersonaEntity toEntity(Persona domain) {
        if (domain == null) return null;
        return PersonaEntity.builder()
                .personaId(domain.getPersonaId())
                .documentoId(domain.getDocumentoId())
                .apellido(domain.getApellido())
                .nombre(domain.getNombre())
                .sexo(domain.getSexo())
                .profesionId(domain.getProfesionId())
                .mascara(domain.getMascara())
                .build();
    }

    public Persona toDomain(PersonaEntity entity) {
        if (entity == null) return null;
        return Persona.builder()
                .personaId(entity.getPersonaId())
                .documentoId(entity.getDocumentoId())
                .apellido(entity.getApellido())
                .nombre(entity.getNombre())
                .sexo(entity.getSexo())
                .profesionId(entity.getProfesionId())
                .mascara(entity.getMascara())
                .build();
    }

}
