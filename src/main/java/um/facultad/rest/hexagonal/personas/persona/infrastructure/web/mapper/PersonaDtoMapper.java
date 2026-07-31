package um.facultad.rest.hexagonal.personas.persona.infrastructure.web.mapper;

import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.personas.persona.domain.model.Persona;
import um.facultad.rest.hexagonal.personas.persona.infrastructure.web.dto.PersonaResponse;

@Component
public class PersonaDtoMapper {

    public PersonaResponse toResponse(Persona domain) {
        if (domain == null) return null;
        return PersonaResponse.builder()
                .personaId(domain.getPersonaId())
                .documentoId(domain.getDocumentoId())
                .apellido(domain.getApellido())
                .nombre(domain.getNombre())
                .sexo(domain.getSexo())
                .profesionId(domain.getProfesionId())
                .mascara(domain.getMascara())
                .build();
    }

}
