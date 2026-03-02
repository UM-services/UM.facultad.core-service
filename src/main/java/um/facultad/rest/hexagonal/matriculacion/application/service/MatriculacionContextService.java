package um.facultad.rest.hexagonal.matriculacion.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import um.facultad.rest.hexagonal.matriculacion.domain.model.Inscripcion;
import um.facultad.rest.hexagonal.matriculacion.domain.model.Persona;
import um.facultad.rest.hexagonal.matriculacion.domain.ports.in.GetInscripcionDataUseCase;
import um.facultad.rest.hexagonal.matriculacion.domain.ports.in.GetPersonaDataUseCase;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class MatriculacionContextService {

    private final GetPersonaDataUseCase getPersonaDataUseCase;
    private final GetInscripcionDataUseCase getInscripcionDataUseCase;

    public Persona getPersona(BigDecimal personaId, Integer documentoId) {
        return getPersonaDataUseCase.getPersona(personaId, documentoId);
    }

    public Inscripcion getInscripcion(BigDecimal personaId, Integer documentoId, Integer lectivoId, Integer facultadId) {
        return getInscripcionDataUseCase.getInscripcion(personaId, documentoId, lectivoId, facultadId);
    }

}
