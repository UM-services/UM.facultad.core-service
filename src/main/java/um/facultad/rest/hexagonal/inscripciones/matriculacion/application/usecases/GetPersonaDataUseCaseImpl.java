package um.facultad.rest.hexagonal.inscripciones.matriculacion.application.usecases;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import um.facultad.rest.hexagonal.personas.persona.domain.model.Persona;
import um.facultad.rest.hexagonal.inscripciones.matriculacion.domain.ports.in.GetPersonaDataUseCase;
import um.facultad.rest.hexagonal.inscripciones.matriculacion.domain.ports.out.MatriculacionContextRepository;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class GetPersonaDataUseCaseImpl implements GetPersonaDataUseCase {

    private final MatriculacionContextRepository matriculacionContextRepository;

    @Override
    public Persona getPersona(BigDecimal personaId, Integer documentoId) {
        return matriculacionContextRepository.findPersonaByPersonaIdAndDocumentoId(personaId, documentoId);
    }

}
